package com.eve.skilleden;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class StaticSkills {
    private List<SkillGroup> byGroup;
    private HashMap<Integer, Skill> skillsById;
    private HashMap<String, Skill> skillsByName;
    private HashMap<Integer, SkillGroup> skillGroupsById;

    StaticSkills() {
        byGroup = new ArrayList<SkillGroup>();
        skillsById = new HashMap<Integer, Skill>();
        skillsByName = new HashMap<String, Skill>();
        skillGroupsById = new HashMap<Integer, SkillGroup>();
    }

    public void load() {
        SkillsDataFile file = new SkillsDataFile();

        for (SkillGroup sg : file.getSkillGroups()) {
            byGroup.add(sg);
        }
    }

    public List<SkillGroup> getByGroup() {
        return byGroup;
    }
}
