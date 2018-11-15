package com.progra.grupo.test;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Perdidos extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private moduloPrincipal cosa;
    private Location loc;
    private final LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            loc = location;
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };
    private Usuario usuario;
    LocationManager lm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdidos);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent intent = getIntent();
        usuario = (Usuario) intent.getSerializableExtra("usuario");
        cosa = (moduloPrincipal) intent.getSerializableExtra("cosa");
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},101);}
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);
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
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},101);
        }
        loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        populateMap(loc);
        try {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lm.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLatitude(), lm.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLongitude()), 15.0f));
        }catch(Exception blyat){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("No hemos podido acceder a tu localización, revisa el estado de GPS y reinicia la app");
            builder.show();
        }
    }

    public void populateMap(Location location){
        for(int i = 0; i< cosa.filtrarAlertas(location).size();i++){
            Alertas alerta = cosa.filtrarAlertas(location).get(i);
            mMap.addMarker(new MarkerOptions().position(alerta.getLugar().toLatLng()).title(alerta.getIdMascota().getNombre()));
        }
    }

    public void onBackPressed(){
        Intent end = new Intent();
        end.putExtra("cosa",cosa);
        end.putExtra("usuario",usuario);
        setResult(RESULT_OK,end);
        finish();
    }

}
