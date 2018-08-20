package com.example.malco.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_slide);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
//            setContentView(R.layout.activity_main);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1,
                    new FirstActivity()).commit();
//        navigationView.setCheckedItem(R.id.nav_why);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
        switch (Item.getItemId()) {
            case R.id.nav_schoology:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1,
                        new SchoologyFragment()).commit();
                break;
            case R.id.nav_infinite_campus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1,
                        new CampusFragment()).commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1,
                        new SettingsFragment()).commit();
                break;
            case R.id.nav_about:
                Toast.makeText(this, "worked now have the layer done", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_why:
                Intent h = new Intent(MainActivity.this, Why.class);
                startActivity(h);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}