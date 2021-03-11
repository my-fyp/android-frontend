package com.example.homeservice.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.homeservice.R;
import com.example.homeservice.ui.alert.AlertFragment;
import com.example.homeservice.ui.explore.ExploreFragment;
import com.example.homeservice.ui.profile.ProfileActivity;
import com.example.homeservice.ui.project.ProjectFragment;
import com.example.homeservice.ui.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavView;
    private Fragment active, exploreFragment, searchFragment, projectFragment, alertFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initUi();
        placeFragment();
        addFragments();
        onNavBottomItemClick();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();
    }

    private void placeFragment() {
        exploreFragment = new ExploreFragment();
        searchFragment = new SearchFragment();
        projectFragment = new ProjectFragment();
        alertFragment = new AlertFragment();
        fragmentManager = getSupportFragmentManager();
        active = exploreFragment;
    }

    private void addFragments() {
        fragmentManager.beginTransaction().add(R.id.container, searchFragment, "search").hide(searchFragment).commit();
        fragmentManager.beginTransaction().add(R.id.container, alertFragment, "alert").hide(alertFragment).commit();
        fragmentManager.beginTransaction().add(R.id.container, projectFragment, "project").hide(projectFragment).commit();
        fragmentManager.beginTransaction().add(R.id.container, active, "home").commit();
    }

    private void onNavBottomItemClick() {
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.action_home) {
                    setActiveFragment(exploreFragment);
                    return true;
                } else if (id == R.id.action_search) {
                    setActiveFragment(searchFragment);
                    return true;
                } else if (id == R.id.action_booking) {
                    setActiveFragment(projectFragment);
                    return true;
                } else {
                    setActiveFragment(alertFragment);
                    return true;
                }
            }
        });
    }

    private void setActiveFragment(Fragment selectedFragment) {
        fragmentManager.beginTransaction().hide(active).show(selectedFragment).commit();
        active = selectedFragment;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent = null;
        if (id == R.id.nav_profile) {
            intent = new Intent(this, ProfileActivity.class);
        }
        drawer.closeDrawer(navigationView);
        startActivity(intent);
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard, menu);
        return true;
    }

    private void initUi() {
        bottomNavView = findViewById(R.id.bottomNavView);
    }
}