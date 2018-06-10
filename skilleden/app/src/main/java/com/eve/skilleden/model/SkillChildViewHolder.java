package com.eve.skilleden.model;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.eve.skilleden.R;
import com.eve.skilleden.model.Skill;

/**
 * Displays the text view for a particular skill
 * source:http://bignerdranch.github.io/expandable-recycler-view/
 */
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
