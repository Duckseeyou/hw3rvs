package com.m3.hw3rvs.ContinentsRecycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m3.hw3rvs.R;

import java.util.ArrayList;

public class ContinentsAdapter extends RecyclerView.Adapter<ContinentsViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Continent> continents;
    public static OnClickListener onClickListener;



    public ContinentsAdapter(LayoutInflater inflater, ArrayList<Continent> continents) {
        this.inflater = inflater;
        this.continents = continents;
    }

    @NonNull
    @Override
    public ContinentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.items, parent, false);
        return new ContinentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentsViewHolder holder, int position) {
        Continent continent = continents.get(position);
        holder.onBind(continent);

        holder.itemView.setOnClickListener(view -> {
            if (onClickListener != null) {
                onClickListener.onClick(position, continent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return continents.size();
    }


    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(int position, Continent continent);
    }

}
