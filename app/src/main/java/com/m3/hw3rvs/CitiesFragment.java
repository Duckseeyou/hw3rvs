package com.m3.hw3rvs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m3.hw3rvs.CitiesRecycleView.CitiesAdapter;
import com.m3.hw3rvs.CitiesRecycleView.City;
import com.m3.hw3rvs.databinding.FragmentCitiesBinding;

import java.util.ArrayList;


public class CitiesFragment extends Fragment {
    FragmentCitiesBinding binding;
    ArrayList<City> cities = new ArrayList<>();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCitiesBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        initRV();
    }

    private void loadData() {

        if (getArguments() != null){
              if (getArguments().getInt("continent_key") == 0) {
                  if (getArguments().getInt("country_key") == 0){
                      cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Bishkek-capital-of-Kyrgyzstan.jpg/450px-Bishkek-capital-of-Kyrgyzstan.jpg",
                              "Бишкек"));
                      cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Osh_03-2016_img26_view_from_Sulayman_Mountain.jpg/435px-Osh_03-2016_img26_view_from_Sulayman_Mountain.jpg",
                              "Ош"));
                  }
                  if (getArguments().getInt("country_key") == 1){
                      cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Moscow_July_2011-16.jpg/399px-Moscow_July_2011-16.jpg",
                              "Москва"));
                      cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Western_Military_District_buildings_Saint_Petersburg_arch.jpg/198px-Western_Military_District_buildings_Saint_Petersburg_arch.jpg",
                              "Cанкт-Петербург"));
                  }
              }
            if (getArguments().getInt("continent_key") == 1) {
                if (getArguments().getInt("country_key") == 0){
                    cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/1/11/Cape_Town_Montage.png",
                            "Кейптаун"));
                    cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Montage_Johannesburg.jpg/435px-Montage_Johannesburg.jpg",
                            "Йоханнесбург"));
                }
                if (getArguments().getInt("country_key") == 1){
                    cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Nairobi_Montage.jpg/435px-Nairobi_Montage.jpg",
                            "Найроби"));
                    cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d6/Mombasa_montage.png/435px-Mombasa_montage.png",
                            "Момбаса"));
                }
            }
            if (getArguments().getInt("continent_key") == 2) {
                if (getArguments().getInt("country_key") == 0){
                    cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/View_of_Empire_State_Building_from_Rockefeller_Center_New_York_City_dllu.jpg/399px-View_of_Empire_State_Building_from_Rockefeller_Center_New_York_City_dllu.jpg",
                            "Нью-Йорк"));
                    cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Chicago_montage.jpg/435px-Chicago_montage.jpg",
                            "Чикаго"));
                }
                if (getArguments().getInt("country_key") == 1){
                    cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Montage_of_Toronto_7.jpg/435px-Montage_of_Toronto_7.jpg",
                            "Торонто"));
                    cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Quebec_City_Montage_2016.jpg/435px-Quebec_City_Montage_2016.jpg",
                            "Квебек"));
                }
            }
            if (getArguments().getInt("continent_key") == 3) {
                if (getArguments().getInt("country_key") == 0){
                    cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Montagem_RJ.jpg/435px-Montagem_RJ.jpg",
                            "Рио-де-Жанейро"));
                    cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Montagem_SP.png/435px-Montagem_SP.png",
                            "Сан-Паулу"));
                }
                if (getArguments().getInt("country_key") == 1){
                    cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Montaje_de_la_Ciudad_de_Buenos_Aires.png/435px-Montaje_de_la_Ciudad_de_Buenos_Aires.png",
                            "Буэнос-Айрес"));
                    cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Santa_Fe_Montage.jpg/435px-Santa_Fe_Montage.jpg",
                            "Санта-Фе"));
                }
            }
            if (getArguments().getInt("continent_key") == 5) {
                if (getArguments().getInt("country_key") == 0){
                    cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Sydney_montage_2018.jpg/381px-Sydney_montage_2018.jpg",
                            "Сидней"));
                    cities.add(new City("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Canberra_montage_2.jpg/435px-Canberra_montage_2.jpg",
                            "Канберра"));
                }
            }
        }

    }

    private void initRV(){
        RecyclerView recyclerView = binding.rvCities;
        CitiesAdapter adapter = new CitiesAdapter(this.getLayoutInflater(), cities);
        recyclerView.setAdapter(adapter);
    }
}