package com.example.homeservice.ui.search;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeservice.R;
import com.example.homeservice.helper.Specialist;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SpecialistAdapter extends RecyclerView.Adapter<SpecialistAdapter.SpecialistViewHolder> {

    ArrayList<Specialist> SpecialistLocations;

    public SpecialistAdapter(ArrayList<Specialist> specialists) {
        SpecialistLocations = specialists;
    }

    @NonNull
    @Override
    public SpecialistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_specialists,parent,false);
        SpecialistViewHolder specialistViewHolder=new SpecialistViewHolder(view);
        return specialistViewHolder;

    }

    @Override//Specialist is helper class
    public void onBindViewHolder(@NonNull SpecialistViewHolder holder, int position) {
        Specialist specialist=SpecialistLocations.get(position);
        holder.image.setImageResource(specialist.getImage());
        holder.title.setText(specialist.getTitle());
        holder.rating.setText(specialist.getRating());
        holder.Desp.setText(specialist.getDescriptions());
    }

    @Override
    public int getItemCount() {
        return SpecialistLocations.size();
    }

    public static  class SpecialistViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView rating,title,Desp;

        public SpecialistViewHolder(@NonNull View itemView) {
            super(itemView);

            //hooks
            image   =itemView.findViewById(R.id.IvTittle);
            rating=itemView.findViewById(R.id.Rating);
            title   =itemView.findViewById(R.id.tvImage);
            Desp   =itemView.findViewById(R.id.TvImageDes);

        }
    }
}
