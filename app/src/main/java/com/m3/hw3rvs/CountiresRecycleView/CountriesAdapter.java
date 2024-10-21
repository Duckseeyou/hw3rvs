package com.m3.hw3rvs.CountiresRecycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.m3.hw3rvs.R;

import java.util.ArrayList;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<Country> countries;
    public static OnClickListener onClickListener;


    public CountriesAdapter(LayoutInflater inflater, ArrayList<Country> countries) {
        this.inflater = inflater;
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.items, parent, false);
        return new CountriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.onBind(country);
        holder.itemView.setOnClickListener(view -> {
            if (onClickListener != null) {
                onClickListener.onClick(position, country);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void setOnClickListener(CountriesAdapter.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(int position, Country country);
    }

}
