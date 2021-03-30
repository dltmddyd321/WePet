package com.tistory.webnautes.wepet;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Event extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gridAdapter = new  MyGridAdapter(this);
        gv.setAdapter(gridAdapter);
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;
        public MyGridAdapter(Context c) {
            context = c;
        }

        Integer[] posterID = {
                R.drawable.gw1 , R.drawable.gw2, R.drawable.gw3, R.drawable.gw4,
                R.drawable.gw8 , R.drawable.gw7, R.drawable.gw6, R.drawable.gw5,
                R.drawable.gw1 , R.drawable.gw2, R.drawable.gw3, R.drawable.gw4,
                R.drawable.gw8 , R.drawable.gw7, R.drawable.gw6, R.drawable.gw5,
        };

        @Override
        public int getCount() {
            return posterID.length;
        }


        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(400,400));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);



            imageView.setImageResource(posterID[position]);

            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(Event.this,R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Event.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle("이벤트 안내");
                    dlg.setIcon(R.drawable.nougat);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();
                }
            });

            return imageView;
        }
    }
}