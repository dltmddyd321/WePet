package com.tistory.webnautes.wepet;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Member extends AppCompatActivity {

    myDBHelper myHelper;
    EditText edtID, edtPass, edtName, edtBirth, edtIDResult, edtPassResult, edtNameResult, edtBirthResult, edtPhone;
    Button btnInit, btnInsert, btnSelect,btnMain;
    SQLiteDatabase sqlDB;
    CheckBox chk1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("WePet 회원가입");

        edtID = (EditText) findViewById(R.id.edtID);
        edtPass = (EditText) findViewById(R.id.edtPass);
        edtName = (EditText) findViewById(R.id.edtName);
        edtBirth = (EditText) findViewById(R.id.edtBirth);
        edtPhone = (EditText)findViewById(R.id.edtPhone);
        chk1 = (CheckBox) findViewById(R.id.chk1);

        edtIDResult = (EditText) findViewById(R.id.edtIDResult);
        edtPassResult = (EditText) findViewById(R.id.edtPassResult);
        edtNameResult = (EditText) findViewById(R.id.edtNameResult);
        edtBirthResult = (EditText) findViewById(R.id.edtBirthResult);

        btnInit = (Button)  findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSelect = (Button) findViewById(R.id.btnSelect);
        btnMain = (Button)findViewById(R.id.btnHome);

        myHelper = new myDBHelper(this);

        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 체크박스가 체크 안될 경우.
                if (!isChecked) {
                    // 입력한 패스워드 문자가 출력됨 (ex . 5456)
                    edtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // 입력한 패스워드의 문자가 보이지 않음 (ex. ****)
                    edtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        btnInit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
            }
        });

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            public void onClick(View v) {
                // TODO Auto-generated method stub
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ( '" + edtID.getText().toString() + "' , '" + edtPass.getText().toString() + "' , '" + edtName.getText().toString() + "', '" + edtBirth.getText().toString() + "','" + edtPhone.getText().toString() + "');");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "가입완료" , 0).show();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

                String strID = "ID" + "\r\n" + "--------" + "\r\n";
                String strPass = "Password" + "\r\n" + "--------" + "\r\n";
                String strName = "이름" + "\r\n" + "--------" + "\r\n";
                String strBirth = "생일" + "\r\n" + "--------" + "\r\n";

                while(cursor.moveToNext()){
                    strID += cursor.getString(0) + "\r\n";
                    strPass += cursor.getString(1) + "\r\n";
                    strName += cursor.getString(2) + "\r\n";
                    strBirth += cursor.getString(3) + "\r\n";
                }

                edtIDResult.setText(strID);
                edtPassResult.setText(strPass);
                edtNameResult.setText(strName);
                edtBirthResult.setText(strBirth);


                cursor.close();
                sqlDB.close();
            }
        });
    }

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context)
        {
            super(context, "groupDB", null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE groupTBL ( gID CHAR(20) PRIMARY KEY, gPassword CHAR(20), gName CHAR(10), gBirth DATE, gPhone INTEGER);");

        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }

    }
}
