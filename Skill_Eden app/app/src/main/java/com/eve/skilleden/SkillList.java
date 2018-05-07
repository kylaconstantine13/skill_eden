package com.eve.skilleden;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//import org.json.*;

public class SkillList {
//    private List<SkillGroup> groupList;

    public SkillList() {
//        groupList = null;
    }

    public static void main(String[] args) {
        SkillList list = new SkillList();
        list.AllSkills();
    }

    public String AllSkills() {
        String gzipfile = "../res/eve_skills.json.gz";
        SkillList skillList = null;

        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(gzipfile);
            GZIPInputStream gis = new GZIPInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            gis.close();
            fis.close();

//            JSONArray skills = new JSONArray(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } //catch (org.json.JSONException e) {
//            e.printStackTrace();
//        }
        System.out.println(sb.toString());
        return sb.toString();
//        return skillList;
    }
}
