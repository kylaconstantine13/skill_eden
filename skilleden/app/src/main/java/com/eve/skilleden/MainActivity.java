package com.eve.skilleden;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    //implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    TextView stringTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        //mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        int id = menuItem.getItemId();

                        if (id == R.id.skill_plans) {

                            // Handle the camera action
                        } else if (id == R.id.skill_list) {
                            stringTextView = (TextView)findViewById(R.id.textView2);
                            List<String> stringData = new ArrayList<String>();
                            stringData.add("ONE");
                            stringData.add("TWO");
                            stringData.add("THREE");
                            stringData.add("Four");
                            stringData.add("Five");
                            stringData.add("Six");
                            stringData.add("Seven");
                            for(int i=0; i < stringData.size(); i++){
                                stringTextView.setText(stringTextView.getText() + stringData.get(i) + " , ");
                            }


                            String json =
                                    "{"
                                            + "'title': 'Computing and Information systems',"
                                            + "'id' : 1,"
                                            + "'children' : 'true',"
                                            + "'groups' : [{"
                                            + "'title' : 'Level one CIS',"
                                            + "'id' : 2,"
                                            + "'children' : 'true',"
                                            + "'groups' : [{"
                                            + "'title' : 'Intro To Computing and Internet',"
                                            + "'id' : 3,"
                                            + "'children': 'false',"
                                            + "'groups':[]"
                                            + "}]"
                                            + "}]"
                                            + "}";

                            // Now do the magic.
                            Data data = new Gson().fromJson(json, Data.class);

                            // Show it.

                        } else if (id == R.id.messaging) {

                        }

                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        return super.onOptionsItemSelected(item);
    }
}

  /*   @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.skill_plans) {

            // Handle the camera action
        }
        else if (id == R.id.skill_list) {
            System.out.println("skill list button clicked");

            String json =
                    "{"
                            + "'title': 'Computing and Information systems',"
                            + "'id' : 1,"
                            + "'children' : 'true',"
                            + "'groups' : [{"
                            + "'title' : 'Level one CIS',"
                            + "'id' : 2,"
                            + "'children' : 'true',"
                            + "'groups' : [{"
                            + "'title' : 'Intro To Computing and Internet',"
                            + "'id' : 3,"
                            + "'children': 'false',"
                            + "'groups':[]"
                            + "}]"
                            + "}]"
                            + "}";

            // Now do the magic.
            Data data = new Gson().fromJson(json, Data.class);

            // Show it.
            System.out.println(data);
        }

        else if (id == R.id.messaging) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}*/