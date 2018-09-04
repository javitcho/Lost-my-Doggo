package com.progra.grupo.lostmydoggo;

import android.location.Location;

public class Alertas {
    private int id;
    private int idMascota;
    private Location lugar;
    private int rango;

    public Alertas(int id, int idMascota, Location lugar, int rango){
    this.id = id;
    this.idMascota= idMascota;
    this.lugar = lugar;
    this.rango = rango;
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

    public int getIdMascota() {
        return idMascota;
    }

    public Location getLugar() {
        return lugar;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public void setLugar(Location lugar) {
        this.lugar = lugar;
    }
}
