package com.eve.skilleden;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.eve.skilleden.model.Skill;

public class SkillDetailActivity extends AppCompatActivity {
    //TODO: eventually change to SKill Detial  holder??
    TextView sNameTextV;
    TextView sCostTextV;
    TextView sRankTextV;
    TextView sPrimaryAttriTextV;
    TextView sSecondaryAttriTextV;
    //    TextView sPrereqTextV; TODO: list view
    TextView sDescTextV;

    ImageButton sAlphaAvail;
    ImageButton sTrialAvail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_detail);
        Skill skill = (Skill) getIntent().getSerializableExtra("skill");
//
        sNameTextV = findViewById(R.id.skill_name);
        sNameTextV.setText(skill.getName());

        sCostTextV = findViewById(R.id.skill_cost);
        sCostTextV.setText(Long.toString(skill.getCost()));

        sRankTextV = findViewById(R.id.skill_rank);
        sRankTextV.setText("Rank: " + Integer.toString(skill.getRank()));

        sPrimaryAttriTextV = findViewById(R.id.skill_primary_attri);
        sPrimaryAttriTextV.setText("Primary Attribute: " + skill.getPrimaryAttr());
//
        sSecondaryAttriTextV = findViewById(R.id.skill_secondary_attri);
        sSecondaryAttriTextV.setText("Secondary Attribute: " + skill.getSecondaryAttr());
//
////        sPrereqTextV = findViewById(R.id.skill_prereq);
////        sPrereqTextV.setText(skill.getPrerequisites());
//
        sDescTextV = findViewById(R.id.skill_description);
        sDescTextV.setText("Description: " + skill.getDescription());

        sAlphaAvail = findViewById(R.id.skill_alpha_avail);
        if (skill.getCanTrainOnAlpha()) {
            sAlphaAvail.setVisibility(View.VISIBLE);
        }

//        sTrialAvail = findViewById(R.id.skill_trial_avail);
//        if (skill.getCanTrainOnTrial()) {
//            sTrialAvail.setVisibility(View.VISIBLE);
//        }
    }
}
