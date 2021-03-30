package com.tistory.webnautes.wepet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Comu extends AppCompatActivity {
    private ListView listView;
    ArrayList<Infor> c_info_list;
    InforAdapter myadapter;
    Infor myInformation1, myInformation2, myInformation3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comu);
        setTitle("커뮤니티");
        listView = (ListView)findViewById(R.id.listView);
        myInformation1 = new Infor("이 동물병원 진짜 추천드려요!!", BitmapFactory.decodeResource(getResources(), R.drawable.ex2));
        myInformation2 = new Infor("이 의사님 어때요??",BitmapFactory.decodeResource(getResources(),R.drawable.doctor));
        myInformation3 = new Infor("로고로고로고로고로고로고",BitmapFactory.decodeResource(getResources(),R.drawable.qa1));

        c_info_list = new ArrayList<Infor>();
        c_info_list.add(myInformation1);
        c_info_list.add(myInformation2);
        c_info_list.add(myInformation3);
        c_info_list.add(myInformation1);
        c_info_list.add(myInformation2);
        c_info_list.add(myInformation3);
        c_info_list.add(myInformation1);
        c_info_list.add(myInformation2);
        c_info_list.add(myInformation3);


        myadapter = new InforAdapter(getApplicationContext(),R.layout.activity_infor, c_info_list);
        listView.setAdapter(myadapter);

    }
}