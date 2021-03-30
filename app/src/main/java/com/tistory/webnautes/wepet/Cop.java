package com.tistory.webnautes.wepet;

import android.graphics.BitmapFactory;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Cop extends AppCompatActivity {
    private ListView listView;
    ArrayList<CopInfor> cop_list;
    CopAdapter myadapter;
    CopInfor mycop1, mycop2, mycop3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cop);
        setTitle("WePet 쿠폰함");
        listView = (ListView)findViewById(R.id.listView);
        mycop1 = new CopInfor("모란 동물병원 용품 증정 쿠폰", BitmapFactory.decodeResource(getResources(), R.drawable.cop), "2020/10/01 ~ 11/01");
        mycop2 = new CopInfor("한빛 동물병원 무료 미용!!!",BitmapFactory.decodeResource(getResources(),R.drawable.cop),"2020/11/08 ~ 11/18");
        mycop3 = new CopInfor("반려견 건강검진 챙기세요",BitmapFactory.decodeResource(getResources(),R.drawable.cop),"기한 만료");

        cop_list = new ArrayList<CopInfor>();
        cop_list.add(mycop1);
        cop_list.add(mycop2);
        cop_list.add(mycop3);

        myadapter = new CopAdapter(getApplicationContext(),R.layout.activity_cop_infor, cop_list);
        listView.setAdapter(myadapter);

    }
}