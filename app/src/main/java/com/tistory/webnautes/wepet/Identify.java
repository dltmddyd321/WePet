package com.tistory.webnautes.wepet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Identify extends Activity {
    TextView edi, id, ide, pw;
    EditText pas;
    Button end;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify);



        edi = (TextView)findViewById(R.id.edit);
        id = (TextView)findViewById(R.id.id);
        ide = (TextView)findViewById(R.id.identify);
        pw = (TextView)findViewById(R.id.pw);
        pas = (EditText)findViewById(R.id.password);
        end = (Button)findViewById(R.id.end);


    }
}
