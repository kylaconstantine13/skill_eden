package com.eve.skilleden.skillmodels;

import android.nfc.Tag;
import android.util.Log;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.eve.skilleden.model.Skill;
import com.eve.skilleden.model.SkillGroup;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class SkillGroupParentObject implements ParentObject {
    private List<Object> mChildrenList;
    public final String name;

    public SkillGroupParentObject(SkillGroup skillGroup) {
        this.mChildrenList = new ArrayList<>();
        this.name = skillGroup.getName();
        Log.d(TAG, "Skills for skill group " + name + ". " + skillGroup.getSkills()); //TODO: remove
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
