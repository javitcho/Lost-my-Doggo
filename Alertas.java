package com.progra.grupo.lostmydoggo;

import android.location.Location;

public class Alertas {
    private int id;
    private Mascota idMascota;
    private Location lugar;
    private int rango;

    public Alertas(int id, Mascota idMascota, Location lugar, int rango){
    this.id = id;
    this.idMascota= idMascota;
    this.lugar = lugar;
    this.rango = rango;
    }

    @Override
    public String toString() {
        String cadena = "id ="+this.id+"\n" +
                "mascota: "+this.idMascota.toString()+"\n" +
                "lugar: "+this.lugar.getLatitude()+","+this.lugar.getLongitude()+"\n" +
                "rango: "+this.rango;
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

    public Location getLugar() {
        return lugar;
    }

    public void setIdMascota(Mascota idMascota) {
        this.idMascota = idMascota;
    }

    public void setLugar(Location lugar) {
        this.lugar = lugar;
    }
}
