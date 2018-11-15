package com.progra.grupo.test;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MisAlertas extends AppCompatActivity {
    private moduloPrincipal cosa;
    RecyclerView recycler;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        usuario = (Usuario) intent.getSerializableExtra("usuario");
        cosa = (moduloPrincipal) intent.getSerializableExtra("cosa");
        setContentView(R.layout.activity_tinder);
        recycler = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        adapter = new Adaptador(cosa.alertasDe(usuario),R.layout.m_text_view);
        recycler.setAdapter(adapter);

    }

    public void onBackPressed(){
        Intent end = new Intent();
        end.putExtra("cosa",cosa);
        end.putExtra("usuario",usuario);
        setResult(RESULT_OK,end);
        finish();
    }





}
