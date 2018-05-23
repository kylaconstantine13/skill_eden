package com.eve.skilleden;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eve.skilleden.model.SkillGroup;

import java.util.List;

import static android.content.ContentValues.TAG;

//TODO: refactor this  //FOR NOW - display skill groups
public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.ViewHolder> {
    private List<SkillGroup> skillGroupList;
    private StaticSkills staticSkills;

    //inner class is responsible for holding views for skill group
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView; //placeholder

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
            mTextView = (TextView) v.findViewById(R.id.skillGroupTextView);

        }

        public TextView getTextView() {
            return mTextView;
        }
    }

    //constructor that takes in a staticskill as input
    public SkillAdapter(StaticSkills staticSkills) {
        this.staticSkills = staticSkills;
        this.skillGroupList = staticSkills.getGroups();

    }

    // Create new views (invoked by the layout manager)
    @Override
    public SkillAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                                      int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.skill_group_row_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(skillGroupList.get(position).toString());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return skillGroupList.size();
    }
}
