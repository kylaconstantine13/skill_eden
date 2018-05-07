package com.eve.skilleden;

import java.util.List;

public class SkillGroup {
    private int id;
    private String name;
    private List<Skill> skills;

    public SkillGroup() {
        this.id = 0;
        this.name = "Unknown Skill Group";
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public int getId() {
        return this.id;
    }
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
    public List<Skill> getSkills() {
        return this.skills;
    }
    public Skill getSkill(int index) {
        return this.skills.get(index);
    }
}
