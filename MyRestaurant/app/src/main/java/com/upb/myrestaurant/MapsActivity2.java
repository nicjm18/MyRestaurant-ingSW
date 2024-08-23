package com.upb.myrestaurant;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.upb.myrestaurant.databinding.ActivityMaps2Binding;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMaps2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaps2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng medellin = new LatLng(6.25184, -75.56359);
        LatLng poblado = new LatLng(6.217000, -75.569367);
        LatLng laureles = new LatLng(6.244832, -75.597866);
        LatLng norte = new LatLng(6.281624, -75.565630);
        LatLng centro = new LatLng(6.226572, -75.573335);

        mMap.addMarker(new MarkerOptions().position(laureles).title("Sede Laureles"));
        mMap.addMarker(new MarkerOptions().position(poblado).title("Sede Poblado"));
        mMap.addMarker(new MarkerOptions().position(centro).title("Sede Centro"));
        mMap.addMarker(new MarkerOptions().position(norte).title("Sede Norte"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(laureles,18));
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }
}