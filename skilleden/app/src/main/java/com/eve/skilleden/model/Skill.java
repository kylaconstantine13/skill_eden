package com.eve.skilleden.model;

import android.support.annotation.NonNull;

import java.util.List;

public class Skill {
    private int id;
    private String name;
    private String description;
    private int alphaLevelCap;
    private Boolean canTrainOnAlpha;
    private Boolean canTrainOnTrial;
    private long cost;
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

    public Skill(@NonNull String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getGroup() {
        return this.group;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", alphaLevelCap=" + alphaLevelCap +
//                ", canTrainOnAlpha=" + canTrainOnAlpha +
//                ", canTrainOnTrial=" + canTrainOnTrial +
//                ", cost=" + cost +
//                ", prerequisites=" + prerequisites +
//                ", primaryAttr='" + primaryAttr + '\'' +
//                ", secondaryAttr='" + secondaryAttr + '\'' +
//                ", rank=" + rank + TODO: format later
                '}';
    }
}
