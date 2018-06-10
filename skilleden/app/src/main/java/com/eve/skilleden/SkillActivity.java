package com.eve.skilleden;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.eve.skilleden.model.SkillGroup;
import com.eve.skilleden.model.SkillGroupParentObject;

import java.util.ArrayList;

/**
 * Activity for Skill List Feature.
 * Displays skillGroups using an expandable recycler view.
 */
public class SkillActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SkillAdapter skillAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private StaticSkills staticSkills;
    private SkillGroupAdapter skillGroupAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skill_list_recycle_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // Improves performance. content does not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        /* load static skill data to create parent group objects that hold skill groups */
        staticSkills = new StaticSkills();
        staticSkills.load(getAssets());

        ArrayList<ParentObject> parentSkillGroupObjects = new ArrayList<>();
        for (SkillGroup skillGroup : staticSkills.getGroups()) {
            ParentObject skillGroupParentObj = new SkillGroupParentObject(skillGroup);
            parentSkillGroupObjects.add(skillGroupParentObj);
        }
        skillGroupAdapter = new SkillGroupAdapter(this, parentSkillGroupObjects);
        mRecyclerView.setAdapter(skillGroupAdapter);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        skillGroupAdapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        skillGroupAdapter.onRestoreInstanceState(savedInstanceState);
    }
}
