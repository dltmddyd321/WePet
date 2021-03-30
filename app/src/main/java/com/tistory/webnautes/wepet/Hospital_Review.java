package com.tistory.webnautes.wepet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hospital_Review extends AppCompatActivity {
    Button btnInfor, btnReview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital__review);

        btnInfor = (Button) findViewById(R.id.btnInfor);
        btnReview = (Button) findViewById(R.id.bntReview);

        btnInfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Hospital_Review.this, Hospital_Information.class);
                startActivity(intent1);
            }
        });

    }
}