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

public class HospList extends AppCompatActivity {
    private ListView listView;
    ArrayList<Hospital> h_info_list;
    HospitalAdapter myAdepter;
    Hospital hospital1,hospital2,hospital3,hospital4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosp_list);
        setTitle("동물병원 목록");
        listView = (ListView)findViewById(R.id.listView);
        hospital1 = new Hospital("굿모닝 동물병원","경기도 성남시 수정구" ,BitmapFactory.decodeResource(getResources(), R.drawable.ex2));
        hospital2 = new Hospital("성남 신구 동물병원 ","경기도 성남시 중원구",BitmapFactory.decodeResource(getResources(),R.drawable.ex2));
        hospital3 = new Hospital("성남 모란 동물병원","경기도 성남시 성남동",BitmapFactory.decodeResource(getResources(),R.drawable.ex2));
        hospital4 = new Hospital("성남 태평 동물병원","경기도 성남시 태평동",BitmapFactory.decodeResource(getResources(),R.drawable.ex2));

        h_info_list = new ArrayList<Hospital>();
        h_info_list.add(hospital1);
        h_info_list.add(hospital2);
        h_info_list.add(hospital3);
        h_info_list.add(hospital4);
        h_info_list.add(hospital1);
        h_info_list.add(hospital2);
        h_info_list.add(hospital3);
        h_info_list.add(hospital4);
        h_info_list.add(hospital1);

        myAdepter = new HospitalAdapter(getApplicationContext(),R.layout.hospital_infor, h_info_list);
        listView.setAdapter(myAdepter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Hospital_Information.class);// 다음넘어갈 화면
                startActivity(intent);
            }
        });
    }
}
