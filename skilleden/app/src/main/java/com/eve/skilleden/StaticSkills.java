package com.eve.skilleden;

import android.content.res.AssetManager;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class StaticSkills {
    private AssetManager assets;
    private List<SkillGroup> groups;
    private List<Skill> skills;
    private HashMap<Integer, SkillGroup> groupsById;
    private HashMap<String, SkillGroup> groupsByName;
    private HashMap<Integer, Skill> skillsById;
    private HashMap<String, Skill> skillsByName;

    StaticSkills() {
        this.groups = new ArrayList<SkillGroup>();
        this.skills = new ArrayList<Skill>();
        this.groupsById = new HashMap<Integer, SkillGroup>();
        this.groupsByName = new HashMap<String, SkillGroup>();
        this.skillsById = new HashMap<Integer, Skill>();
        this.skillsByName = new HashMap<String, Skill>();
        this.assets = null;
    }

    StaticSkills(AssetManager assets) {
        this.groups = new ArrayList<SkillGroup>();
        this.skills = new ArrayList<Skill>();
        this.groupsById = new HashMap<Integer, SkillGroup>();
        this.groupsByName = new HashMap<String, SkillGroup>();
        this.skillsById = new HashMap<Integer, Skill>();
        this.skillsByName = new HashMap<String, Skill>();
        this.assets = assets;
    }

    public void load() {
        SkillsDataFile file;
        if (this.assets != null) {
            file = new SkillsDataFile(assets);
        } else {
            file = new SkillsDataFile();
        }

        for (SkillGroup sg : file.getSkillGroups()) {
            SkillGroup group = new SkillGroup(sg.getId(), sg.getName());
            groups.add(group);
            groupsById.put(group.getId(), group);
            groupsByName.put(group.getName(), group);
            for (Skill s : sg.getSkills()) {
                skills.add(s);
                skillsById.put(s.getId(), s);
                skillsByName.put(s.getName(), s);
            }
        }
    }

    public List<SkillGroup> getGroups() {
        return this.groups;
    }
    public List<Skill> getSkills() {
        return this.skills;
    }
    public HashMap<Integer, SkillGroup> getGroupsById() {
        return this.groupsById;
    }
    public HashMap<String, SkillGroup> getGroupsByName() {
        return this.groupsByName;
    }
    public HashMap<Integer, Skill> getSkillsById() {
        return this.skillsById;
    }
    public HashMap<String, Skill> getSkillsByName() {
        return this.skillsByName;
    }
    public String groupNamesToString() {
        StringBuilder sb = new StringBuilder();
        for (SkillGroup sg : this.groups) {
            sb.append(sg.getName() + "\n");
        }
        return sb.toString();
    }
}
