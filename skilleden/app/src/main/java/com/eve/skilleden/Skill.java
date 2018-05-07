package com.eve.skilleden;

import java.util.List;

public class Skill {
    private int id;
    private String name;
    private String description;
    private int alphaLevelCap;
    private Boolean canTrainOnAlpha;
    private Boolean canTrainOnTrial;
    private int cost;
    private String group;
    private Boolean isPublic;
    private List<Skill> prerequisites;
    private String primaryAttr;
    private String secondaryAttr;
    private int rank;

    public Skill() {
        this.id = 0;
        this.name = "Unknown Skill";
        this.description = "An unknown skill.";
    }

    public Skill(String name) {
        this.name = name;
    }

    public void addSkill(Skill skill) {

    }
}
