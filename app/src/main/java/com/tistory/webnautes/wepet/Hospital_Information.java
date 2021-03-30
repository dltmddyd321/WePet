package com.tistory.webnautes.wepet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hospital_Information extends AppCompatActivity {
    Button btnInfor, btnReview,btnCall,btnSearchWay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital__information);

        btnInfor = (Button) findViewById(R.id.btnInfor);
        btnReview = (Button) findViewById(R.id.btnReview);
        btnCall = (Button) findViewById(R.id.btnCall);
        btnSearchWay = (Button) findViewById(R.id.btnSearchWay);

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), Hospital_Review.class);
                startActivity(intent1);
            }
        });

        btnSearchWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://map.naver.com/"));
                startActivity(intent);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/070-7553-1748"));
                startActivity(intent);
            }
        });
    }
}