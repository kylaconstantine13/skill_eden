package com.eve.skilleden;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import com.eve.skilleden.model.Skill;
import com.eve.skilleden.model.SkillGroup;
import com.google.gson.Gson;

import java.util.*;
import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;

public class SkillList {
    private List<SkillGroup> list;

    public SkillList() {
        list = null;
    }

    public static void main(String[] args) {
        SkillList newList = new SkillList();
        newList.populateAllSkills();
        newList.toString();
    }

    public void populateAllSkills() {
        String gzipfile = "resources/eve_skills.json.gz";
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Type skillGroupListType = new TypeToken<ArrayList<SkillGroup>>() {
        }.getType();
        List<SkillGroup> allSkills = gson.fromJson(sb.toString(), skillGroupListType);
        System.out.println("Test all skills");
        for (SkillGroup skillGroup : allSkills) {
            System.out.println("Skill Group: " + skillGroup.getName());
            for (Skill skill : skillGroup.getSkills()) {
                System.out.println("\t" + skill.getName());
            }
        }
        return;
    }

    public void addGroup(SkillGroup group) {
//        list.append(group);
    }
}
