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
        this.group = "Unknown group";
        this.primaryAttr = "Unknown primary attribute";
        this.secondaryAttr = "Unknown secondary attribute";
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

    public String getDescription() {
        return description;
    }

    public int getAlphaLevelCap() {
        return alphaLevelCap;
    }

    public Boolean getCanTrainOnAlpha() {
        return canTrainOnAlpha;
    }

    public Boolean getCanTrainOnTrial() {
        return canTrainOnTrial;
    }

    public long getCost() {
        return cost;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public List<Skill> getPrerequisites() {
        return prerequisites;
    }

    public String getPrimaryAttr() {
        return primaryAttr;
    }

    public String getSecondaryAttr() {
        return secondaryAttr;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
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
