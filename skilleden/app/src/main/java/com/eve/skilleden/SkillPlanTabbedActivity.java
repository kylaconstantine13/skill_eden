package com.eve.skilleden;

import android.app.ActionBar;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.Context;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.content.res.Resources.Theme;

import android.widget.TextView;

import java.util.ArrayList;

public class SkillPlanTabbedActivity extends AppCompatActivity {

    private static ArrayList<String> basicMining = new ArrayList<>();
    private static ArrayList<String> altMining = new ArrayList<>();
    private static ArrayList<String> advancedMining = new ArrayList<>();
    private static ArrayList<String> tanking = new ArrayList<>();
    private static ArrayList<String> fighter = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_plan_tabbed);

        basicMining.add("Spaceship Command IV : 18 hours");
        basicMining.add("Industry II-V : 5 days 2 hours 33 minutes");
        basicMining.add("Astrogeology I-IV : 2 days 17 hours 35 minutes");
        basicMining.add("Mining Frigate II-III : 7.5 hours");
        basicMining.add("Mining Barge I : 30 minutes");
        basicMining.add("Mining Barge II-V : 20 days 14 hours");
        basicMining.add("Astrogeology V : 12 days 17 hours 25 minutes");
        basicMining.add("Exhumers I-III : 19 hours 19 minutes" + "\n\n" +
                "And you're ready to get into your Hulk (with Strip Miner I).");

        altMining.add("Industry V");
        altMining.add("Mining IV ");
        altMining.add("Astrogeology V");
        altMining.add("Spaceship Command IV");
        altMining.add("Mining Barge V");
        altMining.add("Exhumers III");

        advancedMining.add("Exhumers V");
        advancedMining.add("Mining V");
        advancedMining.add("Target Management IV ");
        advancedMining.add("Long Range Targeting III ");
        advancedMining.add("Mining Upgrades IV ");
        advancedMining.add("Drones V");
        advancedMining.add("Light Drone Operation I");
        advancedMining.add("Veldspar Processing IV");
        advancedMining.add("Scordite Processing IV");
        advancedMining.add("Plagioclase Processing IV");
        advancedMining.add("Ice Harvesting V");
        advancedMining.add("Cybernetics V");
        advancedMining.add("Mining Drone Operation V");
        advancedMining.add("Drone Interfacing V");

        tanking.add("Shield Operation III");
        tanking.add("Shield Management III ");
        tanking.add("Shield Compensation III ");
        tanking.add("Tactical Shield Manipulation IV");
        tanking.add("Kinetic Shield Compensation III");



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Setup spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        //Check the myAdapter constructor
        spinner.setAdapter(new MyAdapter(
                toolbar.getContext(),
                new String[]{
                        "Basic Mining",
                        "Alt Mining",
                        "Advanced Mining",
                        "Tanking",

                }));

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // When the given dropdown item is selected, show its contents in the
                // container view.
                //Creates an instance of PlaceHolderFragment down below lines 140~
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                        .commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Cool little button that we can remove", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_skill_plan_tabbed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        /*else if(id == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }*/


        return super.onOptionsItemSelected(item);
    }


    //This claas helps make the drop down menu
    private static class MyAdapter extends ArrayAdapter<String> implements ThemedSpinnerAdapter {
        private final ThemedSpinnerAdapter.Helper mDropDownHelper;

        public MyAdapter(Context context, String[] objects) {
            super(context, android.R.layout.simple_list_item_1, objects);
            mDropDownHelper = new ThemedSpinnerAdapter.Helper(context);
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                // Inflate the drop down using the helper's LayoutInflater
                LayoutInflater inflater = mDropDownHelper.getDropDownViewInflater();
                view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            } else {
                view = convertView;
            }

            TextView textView = (TextView) view.findViewById(android.R.id.text1);
            textView.setText(getItem(position));

            return view;
        }

        @Override
        public Theme getDropDownViewTheme() {
            return mDropDownHelper.getDropDownViewTheme();
        }

        @Override
        public void setDropDownViewTheme(Theme theme) {
            mDropDownHelper.setDropDownViewTheme(theme);
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        //Insert code here to get the right list displaying
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_skill_plan_tabbed, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            textView.append(" We will insert the array list of our skill plans here");

            StringBuilder builder = new StringBuilder();
            builder.append("\n\n\n\n");

            switch(getArguments().getInt(ARG_SECTION_NUMBER)){
                case 1: for (String details : basicMining) {
                    builder.append("\n" + details + "\n");
                }
                case 2: for (String details : altMining) {
                    builder.append("\n" + details + "\n");
                }
                case 3: for (String details : advancedMining) {
                    builder.append("\n" + details + "\n");
                }
                case 4: for (String details : tanking) {
                    builder.append("\n" + details + "\n");
                }
            }


            textView.setText(builder.toString());


            return rootView;
        }
    }
}
