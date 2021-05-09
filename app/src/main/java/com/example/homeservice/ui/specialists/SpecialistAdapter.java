package com.example.homeservice.ui.specialists;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.homeservice.BaseUrl;
import com.example.homeservice.Constants;
import com.example.homeservice.R;
import com.example.homeservice.helper.GlideOption;
import com.example.homeservice.model.specialist.SpecialistResponse;
import com.example.homeservice.ui.bookingprocess.BookingProcessActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SpecialistAdapter extends RecyclerView.Adapter<SpecialistAdapter.MyViewHolder> {
    private final List<SpecialistResponse> specialists;
    private final String serviceType;

    public SpecialistAdapter(List<SpecialistResponse> specialists, String serviceType) {
        this.specialists = specialists;
        this.serviceType = serviceType;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_item_specialist, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        SpecialistResponse item = specialists.get(position);
        Context context = holder.itemView.getContext();
        holder.tvName.setText(item.getName());
        holder.tvAddress.setText(item.getAddress());

        Glide.with(context)
                .load(BaseUrl.baseUrl + item.getProfileImage())
                .apply(GlideOption.getPersonReqOption())
                .into(holder.civProfile);

        holder.fabCall.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + item.getPhoneNo()));
                context.startActivity(intent);
            } catch (Exception ex) {
                Log.e("Adapter", ex.getMessage());
            }
        });

        holder.btnBook.setOnClickListener(v -> {
            Intent intent = new Intent(context, BookingProcessActivity.class);
            intent.putExtra(Constants.VendorId, item.getVendorId());
            intent.putExtra(Constants.ServiceType, serviceType);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return specialists.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName, tvAddress;
        private final FloatingActionButton fabCall;
        private final CircleImageView civProfile;
        private final Button btnVisitProfile, btnBook;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAddress = itemView.findViewById(R.id.tvContact);
            fabCall = itemView.findViewById(R.id.fabCall);
            civProfile = itemView.findViewById(R.id.ivProfile);
            btnVisitProfile = itemView.findViewById(R.id.btnVisitProfile);
            btnBook = itemView.findViewById(R.id.btnBookNow);
        }
    }
}
