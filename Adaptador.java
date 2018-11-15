package com.progra.grupo.test;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder> {
    private ArrayList<Alertas> alertas;
    int p;
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView view;
        public MyViewHolder(@NonNull TextView itemView) {
            super(itemView);
            view = itemView;
        }
    }

    public Adaptador(ArrayList<Alertas> alertas,int p) {
        this.alertas = alertas;
        this.p = p;
    }
    @NonNull
    @Override
    public Adaptador.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView v = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(this.p,viewGroup,false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.MyViewHolder myViewHolder, int i) {
        myViewHolder.view.setText(alertas.get(i).toString());
    }

    @Override
    public int getItemCount() {
        return alertas.size();
    }
}
