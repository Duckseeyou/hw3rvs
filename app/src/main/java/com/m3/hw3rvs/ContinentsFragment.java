package com.m3.hw3rvs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m3.hw3rvs.ContinentsRecycleView.Continent;
import com.m3.hw3rvs.ContinentsRecycleView.ContinentsAdapter;
import com.m3.hw3rvs.databinding.FragmentContinentsBinding;

import java.util.ArrayList;

public class ContinentsFragment extends Fragment {
    public static ArrayList<Continent> continents = new ArrayList<>();
    private FragmentContinentsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinentsBinding.inflate(getLayoutInflater());
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        initRV();
    }

    private void loadData() {
        if (continents.isEmpty()){
            continents.add(new Continent("https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Eurasia_%28orthographic_projection%29.svg/420px-Eurasia_%28orthographic_projection%29.svg.png",
                    "Евразия"));
            continents.add(new Continent("https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/Africa_%28orthographic_projection%29.svg/420px-Africa_%28orthographic_projection%29.svg.png",
                    "Африка"));
            continents.add(new Continent("https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Location_North_America.svg/280px-Location_North_America.svg.png",
                    "Северная Америка"));
            continents.add(new Continent("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/South_America_%28orthographic_projection%29.svg/280px-South_America_%28orthographic_projection%29.svg.png",
                    "Южная Америка"));
            continents.add(new Continent("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Antarctica_%28orthographic_projection%29.svg/420px-Antarctica_%28orthographic_projection%29.svg.png",
                    "Антарктида"));
            continents.add(new Continent("https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Australia_with_AAT_%28orthographic_projection%29.svg/450px-Australia_with_AAT_%28orthographic_projection%29.svg.png",
                    "Австралия"));
        }

    }

    private void initRV(){
        ContinentsAdapter adapter = new ContinentsAdapter(this.getLayoutInflater(), continents);
        RecyclerView recyclerView = binding.rvContinents;
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener((position, continent) -> {
            Bundle bundle = new Bundle();
            bundle.putInt("continent_key", position);
            CountriesFragment countriesFragment = new CountriesFragment();
            countriesFragment.setArguments(bundle);
            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view_main, countriesFragment).addToBackStack("name").commit();
        });
    }
}