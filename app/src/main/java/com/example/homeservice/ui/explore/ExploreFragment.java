package com.example.homeservice.ui.explore;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeservice.R;
import com.example.homeservice.helper.ViewPagerAdapter;
import com.example.homeservice.ui.alert.AlertFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExploreFragment extends Fragment {
    private final ArrayList<Fragment> fragments = new ArrayList<>();

    ArrayList<String> fragmentNames = new ArrayList<>(Arrays.asList("Offers", "Problems"));

    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_explore, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

        fragments.add(new OffersFragment());
        fragments.add(new PromosFragment());
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(requireActivity(), fragments);
        viewPager.setAdapter(pagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(fragmentNames.get(position))).attach();
    }

    private void initViews(View view) {
        viewPager = view.findViewById(R.id.exploreViewPager);
        tabLayout = view.findViewById(R.id.tablayout);
    }
}