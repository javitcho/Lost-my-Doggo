package com.progra.grupo.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Tinder extends AppCompatActivity {

    moduloPrincipal cosa;
    RecyclerView recycler;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        cosa = (moduloPrincipal) intent.getSerializableExtra("cosa");
        setContentView(R.layout.activity_tinder);
        recycler = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        adapter = new Adaptador(cosa.getAlertas());
        recycler.setAdapter(adapter);
    }

}
