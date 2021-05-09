package com.example.homeservice.ui.search;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.homeservice.R;
import com.example.homeservice.helper.Specialist;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    RecyclerView  feature_recycler;
    RecyclerView.Adapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);

      // feature_recycler= findViewById(R.id.feature_recycler);
       //feature_recycler();

    }

    /*private void feature_recycler() {
        feature_recycler.setHasFixedSize(true);
        feature_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false));

        ArrayList<Specialist> SpecialistLocations=new ArrayList<>();
         SpecialistLocations.add(new Specialist(R.drawable.homecleaner,"four", "HouseCleaner","we do all types of cleaning"));
         SpecialistLocations.add(new Specialist(R.drawable.homecleaner,"Four", "HouseCleaner","we do all types of cleaning"));
         SpecialistLocations.add(new Specialist(R.drawable.homecleaner,"two", "HouseCleaner","we do all types of cleaning"));
         SpecialistLocations.add(new Specialist(R.drawable.homecleaner,"one", "HouseCleaner","we do all types of cleaning"));

         adapter=new SpecialistAdapter(SpecialistLocations);
         feature_recycler.setAdapter(adapter);

        GradientDrawable gardient1=new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xffeff400,0xffaff600});
    }
*/

}
