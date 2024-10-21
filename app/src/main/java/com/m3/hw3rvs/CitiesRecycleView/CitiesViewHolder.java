package com.m3.hw3rvs.CitiesRecycleView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.m3.hw3rvs.R;

public class CitiesViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivImage;
    private TextView tvName;

    public CitiesViewHolder(@NonNull View itemView) {
        super(itemView);
        ivImage = itemView.findViewById(R.id.iv_image);
        tvName = itemView.findViewById(R.id.tv_name);
    }

    void onBind(City city){
        Glide.with(ivImage.getContext()).load(city.getImage()).into(ivImage);
        tvName.setText(city.getName());
    }
}
