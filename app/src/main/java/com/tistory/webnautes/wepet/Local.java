package com.tistory.webnautes.wepet;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;


import androidx.annotation.Nullable;

public class Local extends Filter {
    Button loc, cla, btn4;
    ImageButton gps;
    View.OnClickListener cl;
    Intent i;
    ArrayAdapter<CharSequence> ci, to; //어댑터를 선언했습니다. adspint1(서울,인천..) adspin2(강남구,강서구..)
    String choice_do="";
    String choice_se="";
    EditText loc1, loc2, edtt1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);
        final Spinner spin1 = (Spinner)findViewById(R.id.spinner1);
        final Spinner spin2 = (Spinner)findViewById(R.id.spinner2);
        btn4 = (Button)findViewById(R.id.button4);
        loc1 = (EditText)findViewById(R.id.loc1);
        loc2 = (EditText)findViewById(R.id.loc2);
        edtt1 = (EditText)findViewById(R.id.editTextTextPersonName);

        ci = ArrayAdapter.createFromResource(this, R.array.city, android.R.layout.simple_spinner_dropdown_item);
        ci.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(ci);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(ci.getItem(i).equals("경기")){
                    choice_do = "서울";
                    to = ArrayAdapter.createFromResource(Local.this, R.array.town, android.R.layout.simple_spinner_dropdown_item);
                    to.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(to);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = to.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                    btn4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String s2 = edtt1.getText().toString();
                            sqlDB2 = myHelper2.getReadableDatabase();
                            Cursor cursor = sqlDB2.rawQuery("SELECT * FROM hospital where hName like '%" + s2 + "%';", null);

                            String strNum = "번호" + "\r\n" + "--------" + "\r\n";
                            String strName = "이름" + "\r\n" + "--------" + "\r\n";

                            while(cursor.moveToNext()){
                                strNum += cursor.getString(0) + "\r\n";
                                strName += cursor.getString(1) + "\r\n";
                            }

                            loc1.setText(strNum);
                            loc2.setText(strName);

                            cursor.close();
                            sqlDB2.close();
                        }
                    });

                }else if (ci.getItem(i).equals("서울")){
                    choice_do="서울";
                    to = ArrayAdapter.createFromResource(Local.this, R.array.seoul, android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(to);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_do = to.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        loc = (Button)findViewById(R.id.local1);
        cla = (Button)findViewById(R.id.classification);
        gps = (ImageButton)findViewById(R.id.btn_gps);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {

                    case R.id.classification:
                        cla.setBackgroundColor(Color.YELLOW);
                        i= new Intent(getApplicationContext(),Filter.class);
                        startActivity(i);
                        break;
                    case R.id.btn_gps:
                        i= new Intent(getApplicationContext(), Around.class);
                        startActivity(i);
                        break;
                }
            }
        };
        loc.setOnClickListener(cl);
        cla.setOnClickListener(cl);
        gps.setOnClickListener(cl);
    }
}
