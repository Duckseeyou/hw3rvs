package com.m3.hw3rvs.CitiesRecycleView;

public class City {
    private String name;
    private String image;

    public City(String image, String name){
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }
}

