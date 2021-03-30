package com.tistory.webnautes.wepet;

import android.graphics.Bitmap;

public class Infor { // 커뮤니티의 내용 및 이미지를 담는 클래스
    public String information;
    public Bitmap image;

    Infor(String information, Bitmap image){ // 커뮤니티 내용 생성자 정의
        this.image = image;
        this.information =information;
    }
}
