package com.eve.skilleden.skillmodels;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.eve.skilleden.R;
import com.eve.skilleden.model.Skill;

public class SkillChildViewHolder extends ChildViewHolder {

    public TextView mSkillText;

    public SkillChildViewHolder(View itemView) {
        super(itemView);
        this.mSkillText = (TextView) itemView.findViewById(R.id.skill_item_text_view);
    }

    public void bind(@NonNull Skill skill) {
        mSkillText.setText(skill.getName());
    }
}
