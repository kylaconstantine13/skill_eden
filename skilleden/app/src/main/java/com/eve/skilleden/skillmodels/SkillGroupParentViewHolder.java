package com.eve.skilleden.skillmodels;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.eve.skilleden.R;

public class SkillGroupParentViewHolder extends ParentViewHolder {
    public TextView mTextView;
    @NonNull
    private final ImageView mArrowExpandImageView;

    public SkillGroupParentViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.parent_list_item_skill_group_text_view);
        mArrowExpandImageView = (ImageView) itemView.findViewById(R.id.parent_list_item_expand_arrow);

    }

    public void bind(SkillGroupParentObject skillGroup) {
        mTextView.setText(skillGroup.name);
    }

    /* TODO: implement set expanded? https://github.com/bignerdranch/expandable-recycler-view/blob/master/sampleapp/src/main/java/com/bignerdranch/expandablerecyclerviewsample/linear/vertical/RecipeViewHolder.java*/
}
