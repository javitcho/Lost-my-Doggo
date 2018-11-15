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
            intent.putExtra("usuario",usuario);
            startActivityForResult(intent,2);
        }
        public void irAAlertas(View view){
            Intent intent = new Intent(this,Tinder.class);
            intent.putExtra("cosa",cosa);
            intent.putExtra("usuario",usuario);
            startActivityForResult(intent,2);
        }
        public void irANueva(View view){
            Intent intent = new Intent(this,nuevaAlerta.class);
            intent.putExtra("cosa",cosa);
            intent.putExtra("usuario",usuario);
            startActivityForResult(intent,2);
        }

        public void onBackPressed(){
            moveTaskToBack(true);
        }

        protected void onActivityResult(int requestCode, int resultCode,Intent data){
            if(requestCode==2){
                if(resultCode==RESULT_OK){
                    cosa = (moduloPrincipal) data.getSerializableExtra("cosa");
                    usuario=(Usuario) data.getSerializableExtra("usuario");
                }
            }
        }

        public void irAMisAlertas(View view){
            Intent intent = new Intent(this,MisAlertas.class);
            intent.putExtra("cosa",cosa);
            intent.putExtra("usuario",usuario);
            startActivityForResult(intent,2);
        }

        public void eliminar(View view){
            cosa.eliminarTodas(usuario);
        }

}
