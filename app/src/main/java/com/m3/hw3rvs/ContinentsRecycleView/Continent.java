package com.m3.hw3rvs.ContinentsRecycleView;

public class Continent {
    private String name;
    private String image;

    public Continent(String image, String name) {
        this.image = image;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
