package com.m3.hw3rvs.CountiresRecycleView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.m3.hw3rvs.R;


public class CountriesViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivImage;
    private TextView tvName;

    public CountriesViewHolder(@NonNull View itemView) {
        super(itemView);
        ivImage = itemView.findViewById(R.id.iv_image);
        tvName = itemView.findViewById(R.id.tv_name);
    }

    void onBind(Country country){
        Glide.with(ivImage.getContext()).load(country.getImage()).into(ivImage);
        tvName.setText(country.getName());
    }
}
