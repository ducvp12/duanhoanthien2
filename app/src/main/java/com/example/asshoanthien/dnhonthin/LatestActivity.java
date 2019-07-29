package com.example.asshoanthien.dnhonthin;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asshoanthien.dnhonthin.adapter.AdapterLatest;
import com.example.asshoanthien.dnhonthin.model.ModelLatest;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class LatestActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRvCate;
    private List<ModelLatest> modelLatests;
    private AdapterLatest adapterLatest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest);

        mRvCate = findViewById(R.id.rvlatests);
        modelLatests = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            modelLatests.add(new ModelLatest("", "", "", i + "", i + ""));
        }
        GridLayoutManager layoutManager=new GridLayoutManager(LatestActivity.this,2);
        adapterLatest = new AdapterLatest(modelLatests,this);
         mRvCate.setAdapter(adapterLatest);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRvCate.setLayoutManager(layoutManager);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.category, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_latest) {

        } else if (id == R.id.nav_category) {
            Intent intent=new Intent(LatestActivity.this,CategoryActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_heart) {
            Intent intent=new Intent(LatestActivity.this,MyFavoryitesActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_about_us) {
            Intent intent=new Intent(LatestActivity.this,AboutUsActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_more) {
            Intent intent=new Intent(LatestActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
