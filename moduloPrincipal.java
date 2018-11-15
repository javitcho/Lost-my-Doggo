package com.progra.grupo.test;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

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
        usuarios.add(new Usuario(0,"JuanPerez","1234567",537268163));
        usuarios.add(new Usuario(1,"JoseLopez","Comper95",55993476));
        usuarios.add(new Usuario(2,"MariaLindo","MarixJOrge4eve",46762411));
        usuarios.add(new Usuario(3,"JuanMartinez","AbreSesamo65",65487255));
        usuarios.add(new Usuario(4,"MaximoAurelio","Legion01",46753196));
        usuarios.add(new Usuario(5,"JaimeLopez","OhPapa99",86475523));

        mascotas.add(new Mascota(0,"Pepito","Feo","Feo",null,usuarios.get(0)));
        mascotas.add(new Mascota(1,"Firulais","Chihuahua","Horrible, comprejo de inferioridad",null,usuarios.get(1)));
        mascotas.add(new Mascota(2,"Princesa","Poodle","Cafe",null,usuarios.get(2)));
        mascotas.add(new Mascota(3,"Max","Pitbull","Blanquito",null,usuarios.get(3)));
        mascotas.add(new Mascota(4,"Lorenzo","Cocker","Castaño",null,usuarios.get(4)));
        mascotas.add(new Mascota(5,"Peluche","Labrador","Negro",null,usuarios.get(5)));

        alertas.add(new Alertas(0,mascotas.get(0),new SLatLng(new LatLng(14.6060668,-90.4796671)),10));
        alertas.add(new Alertas(1,mascotas.get(1),new SLatLng(new LatLng(14.6014149,-90.488138)),10));
        alertas.add(new Alertas(2,mascotas.get(2),new SLatLng(new LatLng(14.5985189,-90.4850745)),10));
        alertas.add(new Alertas(3,mascotas.get(3),new SLatLng(new LatLng(14.6203418,-90.48392065)),10));
        alertas.add(new Alertas(4,mascotas.get(4),new SLatLng(new LatLng(14.6083094,-90.5027127)),10));
        alertas.add(new Alertas(5,mascotas.get(5),new SLatLng(new LatLng(14.6039465,-90.5149184)),10));
        this.queries = new queries();
    }

    public void eliminarTodas(Usuario usuario){
        ArrayList<Alertas> mias = alertasDe(usuario);
        for(int i = 0;i<mias.size();i++){
            eliminarAlerta(alertas.indexOf(mias.get(i)));
        }
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
        if(actual != null) {
            ArrayList<Alertas> nueva = new ArrayList<Alertas>();
            for (int i = 0; i < alertas.size(); i++) {
                float distancia[] = new float[1];
                Location.distanceBetween(alertas.get(i).getLugar().getLatitude(), alertas.get(i).getLugar().getLongitude(), actual.getLatitude(), actual.getLongitude(), distancia);
                if ((distancia[0] / 1000) <= alertas.get(i).getRango()) {
                    nueva.add(alertas.get(i));
                }
            }
            return nueva;
        }
        return this.alertas;
    }

    public ArrayList<Alertas> alertasDe(Usuario usuario){
        if(usuario != null) {
            ArrayList<Alertas> nueva = new ArrayList<Alertas>();
            for (int i = 0; i < alertas.size(); i++) {
                if(alertas.get(i).getIdMascota().getIdDueno().getTelefono()==usuario.getTelefono()){
                    nueva.add(alertas.get(i));
                }
            }
            return nueva;
        }
        return this.alertas;
    }



    public void agregarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }
    public void agregarMascota(Mascota mascota){
        this.mascotas.add(mascota);
    }

}
