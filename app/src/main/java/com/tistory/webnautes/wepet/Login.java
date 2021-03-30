package com.tistory.webnautes.wepet;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Login extends Member {


    EditText idinput;
    EditText passwordInput;
    Button login;
    Button signup, nologin;
    String Cname;
    String Cmajor;
    String Text1;
    String Text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("WePet 로그인");

        idinput = (EditText) findViewById(R.id.idInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        login = (Button) findViewById(R.id.loginButton);
        signup = (Button) findViewById(R.id.signupButton);
        nologin = (Button) findViewById(R.id.noLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(databaseList()!=null) {
                    sqlDB = myHelper.getReadableDatabase();
                    Cursor cursor = sqlDB.rawQuery("SELECT gID, gPassword FROM groupTBL;",null);

                    cursor.moveToNext();
                    Cname = cursor.getString(0);
                    Cmajor = cursor.getString(1);
                    Text1 = idinput.getText().toString();
                    Text2 = passwordInput.getText().toString();
                    if (Text1.equals(Cname) && Text2.equals(Cmajor)) {
                        Intent intent = new Intent(getApplication(),MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),Text1+"님 환영합니다!",Toast.LENGTH_SHORT).show();
                        finish();
                    } else
                        Toast.makeText(getApplicationContext(),"정보가 틀립니다.",Toast.LENGTH_SHORT).show();
                    cursor.close();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        nologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

}