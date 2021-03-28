package com.example.homeservice.ui.project.booking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeservice.R;
import com.example.homeservice.model.BookingModel;
import com.example.homeservice.ui.explore.offer.OfferAdapter;

import java.util.ArrayList;

public class BookingAdapter  extends RecyclerView.Adapter<BookingAdapter.MyViewHolder> {
    private final ArrayList<BookingModel> bookings;

    public BookingAdapter(ArrayList<BookingModel> bookings) {
        this.bookings = bookings;
    }


    @NonNull
    @Override
    public BookingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.adapter_booking_item,parent,false);
        return new BookingAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingAdapter.MyViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
