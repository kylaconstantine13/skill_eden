package com.eve.skilleden.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Skill implements Serializable {
    private int id;
    private String name;
    private String description;

    @SerializedName("alpha_level_cap")
    private int alphaLevelCap;
    @SerializedName("can_train_on_alpha")
    private Boolean canTrainOnAlpha;
    @SerializedName("can_train_on_trial")
    private Boolean canTrainOnTrial;
    private long cost;
    private String group;
    @SerializedName("is_public")
    private Boolean isPublic;
    private List<Skill> prerequisites;
    @SerializedName("primary_attribute")
    private String primaryAttr;
    @SerializedName("secondary_attribute")
    private String secondaryAttr;
    private int rank;

    public Skill() {
        this.id = 0;
        this.name = "Unknown Skill";
        this.description = "An unknown skill.";
        this.group = "Unknown group";
        this.primaryAttr = "Unknown primary attribute";
        this.secondaryAttr = "Unknown secondary attribute";
        this.canTrainOnAlpha = false;
        this.canTrainOnTrial = false;
        this.prerequisites = new ArrayList<>();
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

    public void setCanTrainOnAlpha(Boolean canTrainOnAlpha) {
        this.canTrainOnTrial = canTrainOnAlpha;
    }

    public void setCanTrainOnTrial(Boolean canTrainOnTrial){
        this.canTrainOnTrial = canTrainOnTrial;
    }

    public void setPrerequisites(List<Skill> prerequisites) {
        this.prerequisites = prerequisites;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setAlphaLevelCap(int alphaLevelCap) {
        this.alphaLevelCap = alphaLevelCap;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public void setPrimaryAttr(String primaryAttr) {
        this.primaryAttr = primaryAttr;
    }

    public void setSecondaryAttr(String secondaryAttr) {
        this.secondaryAttr = secondaryAttr;
    }

    public void setRank(int rank) {
        this.rank = rank;
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
