package com.example.revisionpracticedec2;

import java.util.ArrayList;

public class Places {
    private String name;
    private String smallDesc;
    private String fullDesc;
    private double price;
    private ArrayList<Integer> images;
    private String country;

    public Places(String name, String smallDesc, String fullDesc, double price, ArrayList<Integer> images, String country) {
        this.name = name;
        this.smallDesc = smallDesc;
        this.fullDesc = fullDesc;
        this.price = price;
        this.images = images;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSmallDesc() {
        return smallDesc;
    }

    public void setSmallDesc(String smallDesc) {
        this.smallDesc = smallDesc;
    }

    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Integer> getImages() {
        return images;
    }

    public void setImages(ArrayList<Integer> images) {
        this.images = images;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
