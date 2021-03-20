
package com.example.homeservice.ui.alert;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.homeservice.ui.explore.offer.OffersFragment;
import com.example.homeservice.ui.explore.problem.ProblemFragment;

public class NotificationPageAdapter extends FragmentStatePagerAdapter {

    private int  numOfTabs;
    public NotificationPageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm ,numOfTabs);
        this.numOfTabs=numOfTabs;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new ProblemFragment();
            case 2:
                return new OffersFragment();
            default:
                return null;
        }
    }

    public int getCount() {
        return numOfTabs;
    }
}
