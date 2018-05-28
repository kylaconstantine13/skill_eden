package com.eve.skilleden.skillmodels;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.eve.skilleden.R;
import com.eve.skilleden.model.Skill;

//TODO: implement on click listener that opens a new page /http://bignerdranch.github.io/expandable-recycler-view/
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
