package com.example.guide_touristique;

public class Wilaya {
    private String name;
    private String arabicName;

    public Wilaya(String name, String arabicName) {
        this.name = name;
        this.arabicName = arabicName;
    }

    public String getName() {
        return name;
    }

    public String getArabicName() {
        return arabicName;
    }
}

