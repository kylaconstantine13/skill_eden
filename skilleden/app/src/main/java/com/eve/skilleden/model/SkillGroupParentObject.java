package com.eve.skilleden.model;

import android.util.Log;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**Used by expandable recycler view. Holds the skill group name and skills associated with it.*/
public class SkillGroupParentObject implements ParentObject {
    private List<Object> mChildrenList;
    public final String name;

    public SkillGroupParentObject(SkillGroup skillGroup) {
        this.mChildrenList = new ArrayList<>();
        this.name = skillGroup.getName();
        Log.d(TAG, "Skills for skill group " + name + ". " + skillGroup.getSkills());
        for (Skill skill : skillGroup.getSkills()) {
            mChildrenList.add(skill);
        }
    }

    @Override
    public List<Object> getChildObjectList() {
        return mChildrenList;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        mChildrenList = list;
    }
}
