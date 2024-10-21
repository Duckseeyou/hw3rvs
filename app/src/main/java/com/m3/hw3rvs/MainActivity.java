package com.m3.hw3rvs;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import com.m3.hw3rvs.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ContinentsFragment continentsFragment = new ContinentsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_main, continentsFragment).commit();

    }



}