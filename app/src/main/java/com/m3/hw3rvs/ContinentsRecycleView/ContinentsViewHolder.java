package com.m3.hw3rvs.ContinentsRecycleView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.m3.hw3rvs.R;

public class ContinentsViewHolder extends RecyclerView.ViewHolder{
    private ImageView ivImage;
    private TextView tvName;

    public ContinentsViewHolder(@NonNull View itemView) {
        super(itemView);
        ivImage = itemView.findViewById(R.id.iv_image);
        tvName = itemView.findViewById(R.id.tv_name);
    }

    void onBind(Continent continent){
        Glide.with(ivImage.getContext()).load(continent.getImage()).into(ivImage);
        tvName.setText(continent.getName());
    }
}
