package com.eve.skilleden;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.eve.skilleden.model.Skill;
import com.eve.skilleden.model.SkillGroup;
import com.eve.skilleden.skillmodels.SkillChildViewHolder;
import com.eve.skilleden.skillmodels.SkillGroupParentObject;
import com.eve.skilleden.skillmodels.SkillGroupParentViewHolder;

import java.util.List;

import static android.content.ContentValues.TAG;

//TODO: refacotor or make clickable https://github.com/TellH/RecyclerTreeView
//Source: https://www.bignerdranch.com/blog/expand-a-recyclerview-in-four-steps/?utm_source=Android+Weekly&utm_campaign=8f0cc3ff1f-Android_Weekly_165&utm_medium=email&utm_term=0_4eb677ad19-8f0cc3ff1f-337834121
public class SkillGroupAdapter extends ExpandableRecyclerAdapter<SkillGroupParentViewHolder, SkillChildViewHolder> {
    private LayoutInflater mLayoutInflater;
    private List<ParentObject> skillGroupsParentObject;
    //TODO: see if there is a way to do this wotjit List<ParentObject

    public SkillGroupAdapter(Context context, @NonNull List<ParentObject> parentItemList) {
        super(context, parentItemList);
        this.skillGroupsParentObject = parentItemList;
        this.mLayoutInflater = LayoutInflater.from(context);


    }

    @UiThread
    @NonNull
    @Override
    public SkillGroupParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mLayoutInflater.inflate(R.layout.activity_skill_group_parent, viewGroup, false);
        return new SkillGroupParentViewHolder(view);
    }

    @UiThread
    @NonNull
    @Override
    public SkillChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = mLayoutInflater.inflate(R.layout.activity_skill_child, viewGroup, false);
        return new SkillChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(SkillGroupParentViewHolder skillGroupParentViewHolder, int parentPosition, Object parentObject) {
        SkillGroupParentObject skillGroup = (SkillGroupParentObject) parentObject;
        if (skillGroup == null) {
            Log.d(TAG, "Skill gorup is null!!"); //TODO: remoce
        }
        skillGroupParentViewHolder.bind(skillGroup);
        skillGroupParentViewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, skillGroup.name + " clicked.");
            }
        });
    }

    @Override
    public void onBindChildViewHolder(SkillChildViewHolder skillChildViewHolder, int childPosition, Object childObject) {
        Skill skill = (Skill) childObject;
        skillChildViewHolder.bind(skill);
        skillChildViewHolder.mSkillText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, skill.getName() + " clicked.");
                Context context = v.getContext();
                Intent intent = new Intent(context, SkillDetailActivity.class);
//                intent.putExtra("skill_description", skill.getDescription());
//                intent.putExtra("skill_name", skill.getName());
//                intent.putExtra("skill_cost", skill.getCost());
                context.startActivity(intent);
            }
        });
    }
}