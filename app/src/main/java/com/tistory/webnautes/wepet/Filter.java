package com.tistory.webnautes.wepet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

public class Filter extends AppCompatActivity {
    Button loc, cla, btn,btn2,btn3;
    ImageButton gps;
    View.OnClickListener cl;
    Intent i;
    myDBHelper myHelper2;
    SQLiteDatabase sqlDB2;
    EditText edit1, edit2, edit3;
    CheckBox chk1, chk2, chk3, chk4, chk5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        loc = (Button)findViewById(R.id.local1);
        cla = (Button)findViewById(R.id.classification);
        gps = (ImageButton)findViewById(R.id.btn_gps);
        btn = (Button)findViewById(R.id.btnOK);
        edit3 = (EditText)findViewById(R.id.edit1);
        edit1 =  (EditText) findViewById(R.id.edt1);
        edit2 = (EditText) findViewById(R.id.edt2);
        btn2 = (Button)findViewById(R.id.btnOK2);
        btn3 = (Button)findViewById(R.id.button4);
        chk1 = (CheckBox)findViewById(R.id.checkBox);
        chk2 = (CheckBox)findViewById(R.id.checkBox2);
        chk3 = (CheckBox)findViewById(R.id.checkBox3);
        chk4 = (CheckBox)findViewById(R.id.checkBox4);
        chk5 = (CheckBox)findViewById(R.id.checkBox5);

        myHelper2 = new myDBHelper(this);

        btn2.setOnClickListener(new View.OnClickListener() {
            // TODO Auto-generated method stub
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HospList.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1=edit3.getText().toString();

                sqlDB2 = myHelper2.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB2.rawQuery("SELECT * FROM hospital where hName like '%"+s1+"%';",null);

                String strNum = "번호" + "\r\n" + "--------" + "\r\n";
                String strName = "이름" + "\r\n" + "--------" + "\r\n";

                while(cursor.moveToNext()){
                    strNum += cursor.getString(0) + "\r\n";
                    strName += cursor.getString(1) + "\r\n";

                }

                edit1.setText(strNum);
                edit2.setText(strName);

                cursor.close();
                sqlDB2.close();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk1.isChecked()==true) {
                    sqlDB2 = myHelper2.getReadableDatabase();
                    Cursor cursor;
                    cursor = sqlDB2.rawQuery("SELECT * FROM hospital where hTime = 'Y';",null);

                    String strName = "이름" + "\r\n" + "--------" + "\r\n";
                    String strTime = "시간" + "\r\n" + "--------" + "\r\n";


                    while(cursor.moveToNext()){
                        strName += cursor.getString(1) + "\r\n";
                        strTime += cursor.getString(4) + "\r\n";

                    }

                    edit1.setText(strName);
                    edit2.setText(strTime);

                    cursor.close();
                    sqlDB2.close(); }

                if(chk3.isChecked() == true) {
                    sqlDB2 = myHelper2.getReadableDatabase();
                    Cursor cursor;
                    cursor = sqlDB2.rawQuery("SELECT * FROM hospital order by hRev desc;",null);

                    String strName = "이름" + "\r\n" + "--------" + "\r\n";
                    String strRev = "리뷰" + "\r\n" + "--------" + "\r\n";


                    while(cursor.moveToNext()){
                        strName += cursor.getString(1) + "\r\n";
                        strRev += cursor.getString(5) + "\r\n";

                    }

                    edit1.setText(strName);
                    edit2.setText(strRev);

                    cursor.close();
                    sqlDB2.close();
                }
                if(chk4.isChecked() == true) {
                    sqlDB2 = myHelper2.getReadableDatabase();
                    Cursor cursor;
                    cursor = sqlDB2.rawQuery("SELECT * FROM hospital where hCop = 'Y';",null);

                    String strName = "이름" + "\r\n" + "--------" + "\r\n";
                    String strCop = "쿠폰" + "\r\n" + "--------" + "\r\n";

                    while(cursor.moveToNext()){
                        strName += cursor.getString(1) + "\r\n";
                        strCop += cursor.getString(4) + "\r\n";

                    }

                    edit1.setText(strName);
                    edit2.setText(strCop);

                    cursor.close();
                    sqlDB2.close();
                }

                if(chk1.isChecked()==true && chk3.isChecked() == true) {
                    sqlDB2 = myHelper2.getReadableDatabase();
                    Cursor cursor;
                    cursor = sqlDB2.rawQuery("SELECT * FROM hospital where hTime = 'Y' order by hRev desc;",null);

                    String strName = "이름" + "\r\n" + "--------" + "\r\n";
                    String strTime = "시간" + "\r\n" + "--------" + "\r\n";

                    while(cursor.moveToNext()){
                        strName += cursor.getString(1) + "\r\n";
                        strTime += cursor.getString(4) + "\r\n";

                    }

                    edit1.setText(strName);
                    edit2.setText(strTime);

                    cursor.close();
                    sqlDB2.close(); }
            }
        });

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.local1:
                        loc.setBackgroundColor(Color.YELLOW);
                        i= new Intent(getApplicationContext(), Local.class);
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


    class myDBHelper extends SQLiteOpenHelper{
        myDBHelper(Context c){
            super(c, "hosDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table hospital (hNum INTEGER PRIMARY KEY AUTOINCREMENT, hName VARCHAR(100), hTime CHAR(1), hShop CHAR(1), hCop CAHR(1), hRev INTEGER, hRat INTEGER, hLoc VARCHAR(1000));");
            db.execSQL("INSERT INTO hospital VALUES(null, '모란동물병원', 'Y', 'N', 'Y', 15, 3, '경기 성남시');");
            db.execSQL("INSERT INTO hospital VALUES(null, '금성동물병원', 'Y', 'Y', 'Y', 7, 4, '경기 광주시');");
            db.execSQL("INSERT INTO hospital VALUES(null, '신구종합병원', 'N', 'N', 'Y', 19, 3, '경기 성남시');");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists hospital;");
            onCreate(db);
        }
    }
}