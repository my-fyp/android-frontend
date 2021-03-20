package com.example.homeservice.ui.alert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeservice.R;
import com.example.homeservice.model.NotificationModel;

import java.util.ArrayList;

public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.MyViewHolder> {
    private ArrayList<NotificationModel> notifications;

    public AlertAdapter(ArrayList<NotificationModel> notifications) {
        this.notifications = notifications;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_alert_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NotificationModel notification = notifications.get(position);
        holder.title.setText(notification.getTitle());
        holder.description.setText(notification.getDescription());
        holder.date.setText(notification.getTime());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView title, description, date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            description = itemView.findViewById(R.id.tvDescription);
            date = itemView.findViewById(R.id.tvDate);
        }
    }
}
