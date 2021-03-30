package com.tistory.webnautes.wepet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    Button mainlogin;
    ImageButton hosp, qna, com, cop, event, shop, mem, etc, hurry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("We Pet!!!");

        mainlogin = (Button) findViewById(R.id.mainlogin);
        hosp = (ImageButton) findViewById(R.id.hosp);
        qna = (ImageButton) findViewById(R.id.qna);
        com = (ImageButton) findViewById(R.id.com);
        cop = (ImageButton) findViewById(R.id.cop);
        event = (ImageButton) findViewById(R.id.event);
        shop = (ImageButton) findViewById(R.id.shop);
        mem = (ImageButton) findViewById(R.id.mem);
        etc = (ImageButton) findViewById(R.id.etc);
        hurry = (ImageButton) findViewById(R.id.hurry);

        mainlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 로그인 화면으로 이동
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        hosp.setOnClickListener(new View.OnClickListener() {  // 병원 검색 필터 화면으로 이동
            @Override
            public void onClick(View v) { // 필터화면으로 이동
                Intent intent = new Intent(getApplicationContext(),Filter.class);
                startActivity(intent);
            }
        });

        qna.setOnClickListener(new View.OnClickListener() { // Q&A 화면으로 이동
            @Override
            public void onClick(View v) { // QnA 화면으로 이동
                Intent intent = new Intent(getApplicationContext(),Qna.class);
                startActivity(intent);
            }
        });

        com.setOnClickListener(new View.OnClickListener() { // 커뮤니티 화면으로 이동
            @Override
            public void onClick(View v) { // 커뮤니티 화면으로 이동
                Intent intent = new Intent(getApplicationContext(),Comu.class);
                startActivity(intent);
            }
        });

        cop.setOnClickListener(new View.OnClickListener() { // 쿠폰함 화면으로 이동
            @Override
            public void onClick(View v) {  // 쿠폰함 화면으로 이동
                Intent intent = new Intent(getApplicationContext(),Cop.class);
                startActivity(intent);
            }
        });

        event.setOnClickListener(new View.OnClickListener() { // 이벤트 화면으로 이동
            @Override
            public void onClick(View v) { // 이벤트 화면으로 이동
                Intent intent = new Intent(getApplicationContext(),Event.class);
                startActivity(intent);
            }
        });

        shop.setOnClickListener(new View.OnClickListener() { // 미용 가능 동물병원 검색 이동
            @Override
            public void onClick(View v) { // 미용 검색 결과로 이동 !!!
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        mem.setOnClickListener(new View.OnClickListener() { // 멤버십 페이지 이동
            @Override
            public void onClick(View v) { // 멤버십 화면으로 이동 !!!
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        etc.setOnClickListener(new View.OnClickListener() { // 설정 화면으로 이동
            @Override
            public void onClick(View v) { // 설정화면으로 이동
                Intent intent = new Intent(getApplicationContext(),Setting.class);
                startActivity(intent);
            }
        });

        hurry.setOnClickListener(new View.OnClickListener() {  // 응급버튼 ( 구현 예정 )
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Hurry.class);
                startActivity(intent);
            }
        });
    }
}