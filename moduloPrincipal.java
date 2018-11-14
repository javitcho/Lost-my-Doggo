package com.progra.grupo.test;

import android.location.Location;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

public class moduloPrincipal implements Serializable{
    private ArrayList<Alertas> alertas;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Mascota> mascotas;
    private queries queries;

    public moduloPrincipal(){
        this.alertas = new ArrayList();
        this.usuarios = new ArrayList();
        this.mascotas = new ArrayList();
        this.queries = new queries();
    }

    public int login(String nombre,String contrasena){
        int j = 0;
        boolean existe = false;
        for(int i = 0;i < this.usuarios.size();i++){
            if(this.usuarios.get(i).validar(nombre,contrasena)){
                j = i;
                existe = true;
                break;
            }
        }
        if(existe){
            return j;
        }else{
            return -1;
        }
    }

    public ArrayList<Alertas> getAlertas() {
        return alertas;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public queries getQueries() {
        return queries;
    }

    public void setAlertas(ArrayList<Alertas> alertas) {
        this.alertas = alertas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public void setQueries(queries queries) {
        this.queries = queries;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void eliminarAlerta(int id){
        for(int i = 0; i<this.alertas.size();i++){
            if(this.alertas.get(i).getId()==id){
                this.alertas.remove(i);
                break;
            }
        }
    }

    public void nuevaAlerta(Alertas alerta){
        this.alertas.add(alerta);
    }

    public ArrayList<Alertas> filtrarAlertas(Location actual){
        ArrayList<Alertas> nueva = new ArrayList<Alertas>();
        for(int i = 0; i<alertas.size();i++){
            float distancia[] = new float[1];
            Location.distanceBetween(alertas.get(i).getLugar().getLatitude(), alertas.get(i).getLugar().getLongitude(), actual.getLatitude(), actual.getLongitude(), distancia);
            if(( distancia[0]/1000) <= alertas.get(i).getRango()){
                nueva.add(alertas.get(i));
            }
        }
        return nueva;
    }

    public void agregarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }
    public void agregarMascota(Mascota mascota){
        this.mascotas.add(mascota);
    }

}
