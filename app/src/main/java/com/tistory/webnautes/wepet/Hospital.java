package com.tistory.webnautes.wepet;

import android.graphics.Bitmap;

public class Hospital {
    public String name, address;
    public Bitmap image;

    public Hospital(String name, String address, Bitmap image) {
        this.name = name;
        this.address = address;
        this.image = image;
    }
}