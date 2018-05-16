package com.eve.skilleden;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.MissingResourceException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import java.net.URL;
import java.io.File;

public class SkillsDataFile {
    private List<SkillGroup> skillGroups;

     SkillsDataFile(AssetManager assets) {
        String gzipfile = "eve_skills.jsongz";
        StringBuilder sb = new StringBuilder();
        try {

            FileInputStream fis = null;
            if (assets != null) {
                AssetFileDescriptor fileDescriptor = assets.openFd(gzipfile);
                fis = fileDescriptor.createInputStream();
            } else {
                URL resource = this.getClass().getClassLoader().getResource(gzipfile);

                if (resource == null) {
                    throw new MissingResourceException("Unable to load skills resource", this.getClass().toString(), gzipfile);
                }

                File file;
                try {
                    file = new File(resource.toURI());
                } catch (java.net.URISyntaxException e) {
                    e.printStackTrace();
                    return;
                }

                fis = new FileInputStream(file);
            }

            if (fis == null) {
                throw new MissingResourceException("Unable to load skills resource", this.getClass().toString(), gzipfile);
            }
            GZIPInputStream gis = new GZIPInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            gis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Type skillGroupListType = new TypeToken<ArrayList<SkillGroup>>(){}.getType();
        this.skillGroups = gson.fromJson(sb.toString(), skillGroupListType);
    }

    public List<SkillGroup> getSkillGroups() {
        return this.skillGroups;
    }
}
