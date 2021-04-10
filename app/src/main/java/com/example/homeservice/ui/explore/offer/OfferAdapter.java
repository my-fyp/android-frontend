package com.example.homeservice.ui.explore.offer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.homeservice.R;
import com.example.homeservice.helper.DateFormatter;
import com.example.homeservice.helper.GlideOption;
import com.example.homeservice.model.offer.OfferResponse;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.MyViewHolder> {
    private final List<OfferResponse> offers;

    public OfferAdapter(List<OfferResponse> offers) {
        this.offers = offers;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_offer_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        OfferResponse offer = offers.get(position);
        holder.description.setText(offer.getDescription());
        holder.vendorName.setText(offer.getName());
        holder.addedDate.setText(DateFormatter.formatDate(offer.getCreatedAt(), "dd MMM, yy - hh:mm"));

        Glide.with(context)
                .load(offer.getOfferImage())
                .apply(GlideOption.getRequestOption())
                .into(holder.offerImage);
        Glide.with(context)
                .load(offer.getProfileImage())
                .apply(GlideOption.getRequestOption())
                .into(holder.vendorImage);
    }

    @Override
    public int getItemCount() {
        return offers.size();
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
