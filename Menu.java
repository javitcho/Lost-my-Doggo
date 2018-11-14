package com.progra.grupo.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

    public class Menu extends AppCompatActivity {

        private moduloPrincipal cosa;
        private Usuario usuario;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu);
            Intent intent = getIntent();
            usuario = (Usuario) intent.getSerializableExtra("usuario");
            cosa = (moduloPrincipal) intent.getSerializableExtra("cosa");
        }
        public void irAMenu(View view){
            Intent intent = new Intent(this, Perdidos.class);
            intent.putExtra("cosa",cosa);
            startActivity(intent);
        }
        public void irAAlertas(View view){
            Intent intent = new Intent(this,Tinder.class);
            intent.putExtra("cosa",cosa);
            startActivity(intent);
        }
        public void irANueva(View view){
            Intent intent = new Intent(this,nuevaAlerta.class);
            intent.putExtra("cosa",cosa);
            intent.putExtra("usuario",usuario);
            startActivity(intent);
        }

}
