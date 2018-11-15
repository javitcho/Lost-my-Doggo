package com.progra.grupo.test;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class Alertas implements Serializable{
    private int id;
    private Mascota idMascota;
    private SLatLng lugar;
    private int rango;

    public Alertas(int id, Mascota idMascota, SLatLng lugar, int rango){
    this.id = id;
    this.idMascota= idMascota;
    this.lugar = lugar;
    this.rango = rango;
    }

    @Override
    public String toString() {
        String cadena =
                this.idMascota.toString();
        return cadena;
    }

    public boolean equals(Alertas alerta) {
        if(this.id==alerta.getId()){
            return true;
        }else{
            return false;
        }
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Mascota getIdMascota() {
        return idMascota;
    }

    public SLatLng getLugar() {
        return lugar;
    }

    public void setIdMascota(Mascota idMascota) {
        this.idMascota = idMascota;
    }

    public void setLugar(SLatLng lugar) {
        this.lugar = lugar;
    }
}
