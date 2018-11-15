package com.progra.grupo.test;

import android.media.Image;

import java.io.Serializable;

public class Mascota implements Serializable{
    private String nombre;
    private String descripcion;
    private int id;
    private String color;
    private Usuario idDueno;

    public Mascota(int id,String nombre, String descripcion, String color, Image imagen, Usuario idDueno){
        this.id = id;
        this.nombre = nombre;
        this.descripcion=descripcion;
        this.color = color;
        this.idDueno=idDueno;
    }

    @Override
    public String toString() {
        String cadena = "Nombre: "+this.nombre+"\n" +
                "descripcion: "+this.descripcion+"\n" +
                "color: "+this.color+"\n" +
                "Dueño: \n"+this.idDueno.toString()+"\n";
        return cadena;
    }

    public Usuario getIdDueno() {
        return idDueno;
    }

    public void setIdDueno(Usuario idDueno) {
        this.idDueno = idDueno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
