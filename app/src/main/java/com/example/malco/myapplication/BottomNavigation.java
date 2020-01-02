package com.example.malco.myapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BottomNavigation extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bottomnav);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
		bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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
		});

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
					new FirstActivity()).commit();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == android.R.id.home)
			this.finish();
		return super.onOptionsItemSelected(item);
	}
}