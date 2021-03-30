package com.tistory.webnautes.wepet;

import android.graphics.Bitmap;

public class CopInfor {
    public String information;
    public Bitmap image;
    public String date;

    CopInfor(String information, Bitmap image, String date){
        this.image = image;
        this.information =information;
        this.date = date;
    }
}