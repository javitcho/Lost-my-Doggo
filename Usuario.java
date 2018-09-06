package com.progra.grupo.lostmydoggo;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nombre;
    private String contrasena;
    private int telefono;

    public boolean validar(String nombre, String contrasena){
        if(this.nombre.equals(nombre) && this.contrasena.equals(contrasena)){
            return true;
        }else {
            return false;
        }
    }

    public void responderNotificacion(boolean valid){

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
