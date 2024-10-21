package com.m3.hw3rvs.CitiesRecycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.m3.hw3rvs.R;

import java.util.ArrayList;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesViewHolder> {
    private LayoutInflater inflater;
    private ArrayList<City> cities;


    public CitiesAdapter(LayoutInflater inflater, ArrayList<City> cities) {
        this.inflater = inflater;
        this.cities = cities;
    }

    @NonNull
    @Override
    public CitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.items, parent, false);
        return new CitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesViewHolder holder, int position) {
        City city = cities.get(position);
        holder.onBind(city);
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }


}
