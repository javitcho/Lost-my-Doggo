package com.progra.grupo.lostmydoggo;

import android.media.Image;

public class Mascota {
    private String nombre;
    private String descripcion;
    private int id;
    private String color;
    private Image imagen;
    private Usuario idDueno;

    public Mascota(int id,String nombre, String descripcion, String color, Image imagen, Usuario idDueno){
        this.id = id;
        this.nombre = nombre;
        this.descripcion=descripcion;
        this.color = color;
        this.imagen = imagen;
        this.idDueno=idDueno;
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

    public Image getImagen() {
        return imagen;
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

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
}
