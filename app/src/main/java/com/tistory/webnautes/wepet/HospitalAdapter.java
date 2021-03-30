package com.tistory.webnautes.wepet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class HospitalAdapter extends BaseAdapter {
    private Context mContext = null;
    private int layout = 0;
    private ArrayList<Hospital> data = null;
    private LayoutInflater inflater = null;

    public HospitalAdapter(Context c, int l, ArrayList<Hospital> d) {
        this.mContext = c;
        this.layout = l;
        this.data = d;
        this.inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if(convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
        }
        ImageView Ho_image = (ImageView) convertView.findViewById(R.id.Hospital_image);
        TextView Ho_name = (TextView) convertView.findViewById(R.id.Hospital_Name);
        TextView Ho_address = (TextView) convertView.findViewById(R.id.Hospital_Address);

        Ho_image.setImageBitmap(data.get(position).image);
        Ho_name.setText(data.get(position).name);
        Ho_address.setText(data.get(position).address);


        return convertView;
    }
}