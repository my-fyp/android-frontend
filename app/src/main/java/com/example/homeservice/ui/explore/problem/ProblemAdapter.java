package com.example.homeservice.ui.explore.problem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeservice.R;
import com.example.homeservice.model.OfferModel;
import com.example.homeservice.model.ProblemModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProblemAdapter extends RecyclerView.Adapter<ProblemAdapter.MyViewHolder> {
    private final ArrayList<ProblemModel> problems;

    public ProblemAdapter(ArrayList<ProblemModel> problems) {
        this.problems = problems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_problem_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProblemModel problem = problems.get(position);
        holder.description.setText(problem.getOfferDescription());
        holder.vendorName.setText(problem.getVendorName());
        holder.addedDate.setText(problem.getOfferPostedDate());
        holder.offerImage.setImageResource(problem.getOfferImage());
        holder.vendorImage.setImageResource(problem.getVendorImage());
    }

    @Override
    public int getItemCount() {
        return problems.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final CircleImageView vendorImage;
        private final TextView vendorName, addedDate, description;
        private final ImageView offerImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vendorImage = itemView.findViewById(R.id.ivVendorImage);
            vendorName = itemView.findViewById(R.id.tvName);
            addedDate = itemView.findViewById(R.id.tvAddedDate);
            description = itemView.findViewById(R.id.ivDescription);
            offerImage = itemView.findViewById(R.id.ivOfferImage);

        }
    }
}
