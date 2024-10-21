package com.m3.hw3rvs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.m3.hw3rvs.CountiresRecycleView.Country;
import com.m3.hw3rvs.databinding.FragmentCountriesBinding;
import com.m3.hw3rvs.CountiresRecycleView.CountriesAdapter;


import java.util.ArrayList;

public class CountriesFragment extends Fragment {
    FragmentCountriesBinding binding;
    ArrayList<Country> countries = new ArrayList<>();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCountriesBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        initRV();
    }

    private void loadData() {
        if (countries.isEmpty()){
            if (getArguments() != null){
                switch (getArguments().getInt("continent_key")){
                    case 0:
                        countries.add(new Country("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7c/Kyrgyzstan_%28orthographic_projection%29.svg/450px-Kyrgyzstan_%28orthographic_projection%29.svg.png",
                                "Кыргызстан"));
                        countries.add(new Country("https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Russian_Federation_%28orthographic_projection%29_-_2014%2C_2022_Annexed_Territories_disputed.svg/449px-Russian_Federation_%28orthographic_projection%29_-_2014%2C_2022_Annexed_Territories_disputed.svg.png",
                                "Россия"));
                        break;
                    case 1:
                        countries.add(new Country("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/South_Africa_%28orthographic_projection%29.svg/450px-South_Africa_%28orthographic_projection%29.svg.png",
                                "ЮАР"));
                        countries.add(new Country("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Kenya_%28orthographic_projection%29.svg/450px-Kenya_%28orthographic_projection%29.svg.png",
                                "Кения"));
                        break;
                    case 2:
                        countries.add(new Country("https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/USA_orthographic.svg/450px-USA_orthographic.svg.png",
                                "США"));
                        countries.add(new Country("https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/CAN_orthographic.svg/450px-CAN_orthographic.svg.png",
                                "Канада"));
                        break;
                    case 3:
                        countries.add(new Country("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/BRA_orthographic.svg/450px-BRA_orthographic.svg.png",
                                "Бразилия"));
                        countries.add(new Country("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/ARG_orthographic_%28%2Ball_claims%29.svg/450px-ARG_orthographic_%28%2Ball_claims%29.svg.png",
                                "Аргентина"));
                        break;
                    case 5:
                        countries.add(new Country("https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Australia_with_AAT_%28orthographic_projection%29.svg/450px-Australia_with_AAT_%28orthographic_projection%29.svg.png",
                                "Австралия"));
                }

            }
        }
    }

    private void initRV(){
        RecyclerView recyclerView = binding.rvCountires;
        CountriesAdapter adapter = new CountriesAdapter(this.getLayoutInflater(), countries);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener((position, country) -> {
            Bundle bundle = new Bundle();
            if (getArguments() != null) {
                bundle.putInt("continent_key", getArguments().getInt("continent_key"));
                bundle.putInt("country_key", position);
            }
            CitiesFragment citiesFragment = new CitiesFragment();
            citiesFragment.setArguments(bundle);
            getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view_main, citiesFragment).addToBackStack("name").commit();
        });
    }

}