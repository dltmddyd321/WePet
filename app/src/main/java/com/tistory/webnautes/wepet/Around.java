package com.tistory.webnautes.wepet;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class Around extends AppCompatActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_around);
        setTitle("주변 동물병원");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        LatLng Now = new LatLng(37.432161, 127.129045);
        LatLng Hp1 = new LatLng(37.432744, 127.129160);
        LatLng Hp2 = new LatLng(37.432123, 127.128385);
        LatLng Hp3 = new LatLng(37.431949, 127.128002);

        MarkerOptions markerOptions = new MarkerOptions();
        MarkerOptions markerOptions1 = new MarkerOptions();
        MarkerOptions markerOptions2 = new MarkerOptions();
        MarkerOptions markerOptions3 = new MarkerOptions();

        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.wepet99);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, 100, 100, false);
        markerOptions1.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        markerOptions2.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        markerOptions3.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        markerOptions1.position(Hp1);
        markerOptions.position(Now);
        markerOptions2.position(Hp2);
        markerOptions3.position(Hp3);
        markerOptions1.title("맑음동물종합센터");
        markerOptions1.snippet("경기도 성남시 모란");
        markerOptions2.title("모란종합동물병원");
        markerOptions2.snippet("경기도 성남시 모란");
        markerOptions3.title("21세기동물병원");
        markerOptions3.snippet("경기도 성남시 모란");
        markerOptions.title("내 위치");
        markerOptions.snippet("모란역");
        mMap.addMarker(markerOptions1);
        mMap.addMarker(markerOptions2);
        mMap.addMarker(markerOptions3);
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Now, 17));

    }
}