package com.eve.skilleden.model;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import com.google.gson.Gson;

import java.util.*;
import java.lang.reflect.Type;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//TODO: refactor to build class to try to populate  skills - build ticket - fix SkillListViewModel
//Outdated skill list model. Leaving in temporarily in case work that uses this will be introduced
// at a later date. Will remove before release to Google Play if not utilized in final version.
public class SkillList {
    private List<SkillGroup> skillGroupList;
    private static final Logger log = LoggerFactory.getLogger(SkillList.class);

    public SkillList() {
        skillGroupList = new ArrayList<>();
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
            Gson gson = new Gson();
            Type skillGroupListType = new TypeToken<ArrayList<SkillGroup>>() {
            }.getType();
            List<SkillGroup> allSkills = gson.fromJson(sb.toString(), skillGroupListType);
            for (SkillGroup skillGroup : allSkills) {
                System.out.println("Skill Group: " + skillGroup.getName());
                for (Skill skill : skillGroup.getSkills()) {
                    System.out.println("\t" + skill.getName());
                }
            }
            this.skillGroupList = allSkills;
        } catch (IOException e) {
            log.error("Could not extract skills from local resources.");
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            log.error("Could not transform json to model.");
            e.printStackTrace();
        }
    }

    public List<SkillGroup> getSkillGroups() {
        return this.skillGroupList;
    }

    public Optional<SkillGroup> getSkillGroup(final int skillGroupId) {
        Optional<SkillGroup> skillGroupOpt = Optional.empty();
        for (SkillGroup skillGroup : this.skillGroupList) {
            if (skillGroup.getId() == skillGroupId) {
                skillGroupOpt = Optional.of(skillGroup);
                break;
            }
        }
        return skillGroupOpt;
    }
}
