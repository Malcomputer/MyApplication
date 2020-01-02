package com.example.malco.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class BottomNavigation extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bottomnav);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
		bottomNav.setOnNavigationItemSelectedListener(navListener);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
					new FirstActivity()).commit();
		}
	}

	private BottomNavigationView.OnNavigationItemSelectedListener navListener =
			new BottomNavigationView.OnNavigationItemSelectedListener() {
				@Override
				public boolean onNavigationItemSelected(@NonNull MenuItem item) {
					Fragment selectedFragment = null;

					switch (item.getItemId()) {
						case R.id.nav_home:
							selectedFragment = new HomeFragment();
							break;
						case R.id.nav_search:
							selectedFragment = new SearchFragment();
							break;
						case R.id.nav_add:
							selectedFragment = new AssignmentFragment();
							break;
						case R.id.nav_like:
							selectedFragment = new NotificationFragment();
							break;
						case R.id.nav_profile:
							selectedFragment = new ProfileFragment();
							break;
					}

					getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
							selectedFragment).commit();

					return true;
				}
			};

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == android.R.id.home)
			this.finish();
		return super.onOptionsItemSelected(item);
	}
}