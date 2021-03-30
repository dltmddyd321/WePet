package com.tistory.webnautes.wepet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Setting extends AppCompatActivity {

    TextView it, ed;
    Button id, no, re, qu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setTitle("WePet 설정");

        it = (TextView)findViewById(R.id.item);
        ed = (TextView)findViewById(R.id.edit);
        id = (Button)findViewById(R.id.identify);
        no = (Button)findViewById(R.id.notice);
        re = (Button)findViewById(R.id.review);
        qu = (Button)findViewById(R.id.question);

        id.setBackgroundColor(Color.WHITE);
        no.setBackgroundColor(Color.WHITE);
        re.setBackgroundColor(Color.WHITE);
        qu.setBackgroundColor(Color.WHITE);

        id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Identify.class);
                startActivity(intent);
            }
        });

        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),Reple.class);
                startActivity(intent2);
            }
        });

    }
}