package com.tistory.webnautes.wepet;

import android.graphics.Bitmap;

public class Classificationhospital {
    public String name, address;
    public Bitmap image1, image2, image3;

    public Classificationhospital(String name, String address, Bitmap image1, Bitmap image2) {
        this.name = name;
        this.address = address;
        this.image1 = image1;
        this.image2 = image2;
    }
    public Classificationhospital(String name, String address, Bitmap image1, Bitmap image2, Bitmap image3){
        this.name = name;
        this.address = address;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }
}
