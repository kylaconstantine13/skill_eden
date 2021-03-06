package com.eve.skilleden;

import android.content.res.AssetManager;
import android.util.Log;

import com.eve.skilleden.model.Skill;
import com.eve.skilleden.model.SkillGroup;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import static android.content.ContentValues.TAG;

public class StaticSkills {
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
    }

    StaticSkills(AssetManager assets) {
        this.groups = new ArrayList<SkillGroup>();
        this.skills = new ArrayList<Skill>();
        this.groupsById = new HashMap<Integer, SkillGroup>();
        this.groupsByName = new HashMap<String, SkillGroup>();
        this.skillsById = new HashMap<Integer, Skill>();
        this.skillsByName = new HashMap<String, Skill>();
    }

    public void load() {
        load(null);
    }

    public void load(AssetManager assets) {
        SkillsDataFile file;
        if (assets != null) {
            file = new SkillsDataFile(assets);
        } else {
            file = new SkillsDataFile();
        }

        Log.d(TAG, "Creating static skill list.  "); //TODO: remove
        for (SkillGroup sg : file.getSkillGroups()) {
            SkillGroup group = new SkillGroup(sg.getId(), sg.getName());
            for (Skill s : sg.getSkills()) {
                skills.add(s);
                skillsById.put(s.getId(), s);
                skillsByName.put(s.getName(), s);
            }
            groupsById.put(group.getId(), group);
            groupsByName.put(group.getName(), group);
            group.setSkills(skills);
            groups.add(group);
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
