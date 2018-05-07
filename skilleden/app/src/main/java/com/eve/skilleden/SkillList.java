package com.eve.skilleden;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;

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
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        return;
//        String gzipfile = "eve_skills.json.gz";
//        StringBuilder sb = new StringBuilder();
//        try {
//            FileInputStream fis = new FileInputStream(gzipfile);
//            GZIPInputStream gis = new GZIPInputStream(fis);
//            BufferedReader br = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
//            String line;
//            while ((line = br.readLine()) != null) {
//                sb.append(line);
//            }
//            br.close();
//            gis.close();
//            fis.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        JSONArray allSkills = null;
//        try {
//            allSkills = new JSONArray(sb.toString());
//        } catch (org.json.JSONException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(allSkills.toString());

//        if (allSkills != null) {
//            int len = allSkills.length();
//            for (int i = 0; i < len; ++i) {
//                try {
//                    JSONObject sg = new JSONObject((String) allSkills.get(i));
//                } catch (org.json.JSONException e) {
//                    e.printStackTrace();
//                }
//                SkillGroup skillGroup = new SkillGroup(sg);
//                JSONArray skills = new JSONArray(sg.get("skills"));
//                Iterator skillsIt = skills.iterator();
//                while (skillsIt.hasNext()) {
//                    Skill skill = new Skill(
//                        new JSONObject(skillsIt.next())
//                    );
//                    skillGroup.addSkill(skill);
//                }
//                this.addGroup(skillGroup);
//            }
//        }
    }

    public void addGroup(SkillGroup group) {
//        list.append(group);
    }
}
