package com.eve.skilleden;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


//This class is somewhat useless now that I made an activity with tabs
public class SkillPlanActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SkillAdapter skillAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private StaticSkills staticSkills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_plan);

        //mRecyclerView = (RecyclerView) findViewById(R.id.skill_plan_recycler_view);


    }
}
