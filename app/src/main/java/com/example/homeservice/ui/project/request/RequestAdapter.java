package com.example.homeservice.ui.project.request;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.homeservice.databinding.AdapterRequestItemBinding;
import com.example.homeservice.helper.DateFormatter;
import com.example.homeservice.helper.GlideOption;
import com.example.homeservice.helper.Prefs;
import com.example.homeservice.model.bookingreq.BookingResponse;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.MyViewHolder> {
    private AdapterRequestItemBinding binding;
    private final List<BookingResponse> requests;

    public RequestAdapter(List<BookingResponse> requests) {
        this.requests = requests;
    }


    @NotNull
    @Override
    public RequestAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = AdapterRequestItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding.getRoot());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RequestAdapter.MyViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        BookingResponse item = requests.get(position);
        binding.tvServiceType.setText(item.getServiceType());
        binding.tvDescription.setText(item.getProblemDescription());
        binding.tvAddress.setText(item.getServiceAddress());
        binding.tvServiceOnDate.setText(DateFormatter.formatDate(item.getServiceDate(), "MMM dd, yyyy"));
        binding.tvSendOnDate.setText(DateFormatter.formatDate(item.getBookingDate(), "MMM dd, yyyy"));
        binding.tvPrice.setText("Not estimated yet!");

        /*if (item.getCustomerId() == Prefs.getProfileDetails().getAccessId()) {
            Glide.with(context)
                    .load(item.getCustomerImage())
                    .apply(GlideOption.getPersonReqOption())
                    .into(binding.requestId);
            binding.tvDescription.setText(item.getProblemDescription());
            binding.tvAddress.setText(item.getServiceAddress());
        } else {
            Glide.with(context)
                    .load(item.getVendorImage())
                    .apply(GlideOption.getPersonReqOption())
                    .into(binding.requestId);
            binding.tvDescription.setText(item.getCustomerName());

        }*/
    }

    @Override
    public int getItemCount() {
        return requests.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

