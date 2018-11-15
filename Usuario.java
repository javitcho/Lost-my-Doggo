package com.progra.grupo.test;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable{
    private int id;
    private String nombre;
    private String contrasena;
    private int telefono;

    public Usuario(int id, String nombre, String contrasena, int telefono){
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        String cadena = "Nombre:"+this.nombre+"\n" +
                "telefono:"+this.telefono;
        return cadena;
    }

    public boolean validar(String nombre, String contrasena){
        if(this.nombre.equals(nombre) && this.contrasena.equals(contrasena)){
            return true;
        }else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
