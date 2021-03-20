package com.example.homeservice.ui.profile;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.homeservice.R;
import com.example.homeservice.helper.ViewPagerAdapter;
import com.example.homeservice.ui.explore.offer.OffersFragment;
import com.example.homeservice.ui.explore.problem.ProblemFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;

public class ProfileActivity extends AppCompatActivity {

    private final ArrayList<Fragment> fragments = new ArrayList<>();

    ArrayList<String> fragmentNames = new ArrayList<>(Arrays.asList("Feedback", "Post", "About"));

    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initViews();
        fragments.add(new OffersFragment());
        fragments.add(new ProblemFragment());
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(this, fragments);
        viewPager.setAdapter(pagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(fragmentNames.get(position))).attach();
    }

    private void initViews() {
        viewPager = findViewById(R.id.exploreViewPager);
        tabLayout = findViewById(R.id.tablayout);
    }

}