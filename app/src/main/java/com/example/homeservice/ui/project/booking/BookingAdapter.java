package com.example.homeservice.ui.project.booking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.homeservice.R;
import com.example.homeservice.databinding.AdapterBookingItemBinding;
import com.example.homeservice.helper.GlideOption;
import com.example.homeservice.helper.Prefs;
import com.example.homeservice.model.BookingModel;
import com.example.homeservice.model.bookingreq.BookingResponse;

import java.util.ArrayList;
import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.MyViewHolder> {
    private AdapterBookingItemBinding binding;
    private final List<BookingResponse> bookings;

    public BookingAdapter(List<BookingResponse> bookings) {
        this.bookings = bookings;
    }


    @NonNull
    @Override
    public BookingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = AdapterBookingItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        BookingResponse booking = bookings.get(position);
        binding.tvServiceType.setText(booking.getServiceType());
        binding.tvBookedOnDate.setText(booking.getBookingDate());
        binding.tvServiceOnDate.setText(booking.getServiceDate());

        if (booking.getCustomerId() == Prefs.getProfileDetails().getAccessId()) {
            Glide.with(context)
                    .load(booking.getVendorImage())
                    .apply(GlideOption.getPersonReqOption())
                    .into(binding.civVendorProfile);
            binding.tvVendorName.setText(booking.getVendorName());
            binding.tvContact.setText(booking.getVendorContact());
        } else {
            Glide.with(context)
                    .load(booking.getCustomerImage())
                    .apply(GlideOption.getPersonReqOption())
                    .into(binding.civVendorProfile);
            binding.tvVendorName.setText(booking.getCustomerName());
            binding.tvContact.setText(booking.getCustomerContact());
        }
    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
