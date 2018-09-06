package com.progra.grupo.lostmydoggo;

import android.location.Location;

import java.sql.ResultSet;
import java.util.ArrayList;

public class moduloPrincipal {
    private ArrayList<Alertas> alertas;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Mascota> mascotas;
    private queries queries;
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


}
