package com.eve.skilleden;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

//TODO: change to listview
public class SkillActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SkillAdapter skillAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private StaticSkills staticSkills;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);  //TODO: remove in future?

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        // specify an adapter (see also next example)
        staticSkills = new StaticSkills();
        staticSkills.load(getAssets());
        skillAdapter = new SkillAdapter(staticSkills);
        mRecyclerView.setAdapter(skillAdapter);
    }
}
