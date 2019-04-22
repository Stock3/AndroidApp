package com.example.loginapp.Pages.User;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.loginapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;

        LatLng Maharashtra = new LatLng(19.169257, 73.341601);
        LatLng Chernivtsi  = new LatLng(48.29083, 25.93444);
        LatLng Moevka  = new LatLng(48.463333, 28.223333);

        map.addMarker(new MarkerOptions().position(Maharashtra).title("Maharashtra"));
        map.addMarker(new MarkerOptions().position(Chernivtsi).title("Chernivtsi"));
        map.addMarker(new MarkerOptions().position(Moevka).title("Moevka"));

        map.moveCamera(CameraUpdateFactory.newLatLng(Maharashtra));
        map.moveCamera(CameraUpdateFactory.newLatLng(Chernivtsi));
        map.moveCamera(CameraUpdateFactory.newLatLng(Moevka));


    }
}
