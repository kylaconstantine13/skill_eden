package com.eve.skilleden;

import java.util.List;
import java.util.ArrayList;

public class SkillGroup {
    private int id;
    private String name;
    private List<Skill> skills;

    SkillGroup() {
        this.id = 0;
        this.name = "Unknown Skill Group";
        this.skills = new ArrayList<Skill>();
    }
    SkillGroup(int id, String name) {
        this.id = id;
        this.name = name;
        this.skills = new ArrayList<Skill>();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setskills(List<Skill> skills) {
        this.skills = skills;
    }
    public String getName() {
        return this.name;
    }
    public int getId() {
        return this.id;
    }
    public List<Skill> getSkills() {
        return this.skills;
    }
}
