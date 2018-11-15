package com.progra.grupo.test;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class SLatLng implements Serializable {
    private double latitude;
    private double longitude;

    public SLatLng(LatLng lugar) {
        this.latitude = lugar.latitude;
        this.longitude = lugar.longitude;
    }

    public LatLng toLatLng(){
        return new LatLng(this.latitude,this.longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
