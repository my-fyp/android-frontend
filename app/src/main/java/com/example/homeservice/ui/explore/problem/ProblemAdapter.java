package com.example.homeservice.ui.explore.problem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeservice.R;
import com.example.homeservice.helper.DateFormatter;
import com.example.homeservice.model.problem.ProblemResponse;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProblemAdapter extends RecyclerView.Adapter<ProblemAdapter.MyViewHolder> {
    private final List<ProblemResponse> problems;

    public ProblemAdapter(List<ProblemResponse> problems) {
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
        ProblemResponse problem = problems.get(position);
        holder.description.setText(problem.getDescription());
        holder.addedDate.setText(DateFormatter.formatDate(problem.getCreatedAt(), "dd MMM, yy - hh:mm"));;

        //holder.problemImage.setImageResource(problem.getProblemImage());
        //holder.vendorImage.setImageResource(problem.im());
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
