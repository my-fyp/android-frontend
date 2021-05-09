package com.example.homeservice.ui.search;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.homeservice.BaseUrl;
import com.example.homeservice.Constants;
import com.example.homeservice.R;
import com.example.homeservice.helper.GlideOption;
import com.example.homeservice.model.search.ServiceResponse;
import com.example.homeservice.ui.specialists.SpecialistActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.example.homeservice.Constants.SpecialitySlug;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.MyViewHolder> {
    private final List<ServiceResponse> services;

    public ServiceAdapter(List<ServiceResponse> services) {
        this.services = services;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.adapter_service_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        ServiceResponse item = services.get(position);
        holder.tvServiceName.setText(item.getProfessionName());

        Glide.with(holder.itemView.getContext())
                .load(BaseUrl.baseUrl + item.getServiceIcon())
                .apply(GlideOption.getRequestOption())
                .into(holder.tvServiceIcon);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, SpecialistActivity.class);
            intent.putExtra(SpecialitySlug, item.getSlug());
            intent.putExtra(Constants.ServiceType, item.getProfessionName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvServiceName;
        private final ImageView tvServiceIcon;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvServiceName = itemView.findViewById(R.id.tvServiceName);
            tvServiceIcon = itemView.findViewById(R.id.ivIcon);
        }
    }
}
