package com.example.homeservice.ui.project;

import android.app.TaskStackBuilder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TableLayout;

import com.example.homeservice.R;
import com.example.homeservice.helper.ViewPagerAdapter;
import com.example.homeservice.ui.project.booking.BookingFragment;
import com.example.homeservice.ui.project.request.RequestFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;

public class ProjectFragment extends Fragment {
    private final ArrayList<Fragment> fragments = new ArrayList<>();

    ArrayList<String> fragmentNames = new ArrayList<>(Arrays.asList("Requests", "Bookings"));
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_project, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        fragments.add(new RequestFragment());
        fragments.add(new BookingFragment());
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(requireActivity(), fragments);
        viewPager.setAdapter(pagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(fragmentNames.get(position))).attach();
    }

    private void initViews(View view) {
        viewPager = view.findViewById(R.id.exploreViewPager);
        tabLayout = view.findViewById(R.id.tablayout);
    }
}