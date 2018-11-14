package com.progra.grupo.test;

import android.app.AlertDialog;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class nuevaAlerta extends AppCompatActivity {
    Place place;
    Usuario usuario;
    moduloPrincipal cosa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_alerta);
        Intent intent = getIntent();
        usuario = (Usuario) intent.getSerializableExtra("usuario");
        cosa = (moduloPrincipal) intent.getSerializableExtra("cosa");
    }

    String nombre;
    String descripcion;
    String colour;
    int rango;
    public void siguiente(View view){
        EditText name = (EditText) findViewById(R.id.nombreMascota);
        nombre = name.getText().toString();
        EditText color = (EditText) findViewById(R.id.color);
        colour = color.getText().toString();
        TextView desc = findViewById(R.id.descripcion);
        descripcion = desc.getText().toString();
        SeekBar seekBar = findViewById(R.id.seekBar);
        rango = seekBar.getProgress();
        int PLACE_PICKER_REQUEST = 1;
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {
            startActivityForResult(builder.build(this),PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }

    }

    private void onResult(){
        if(place!=null) {
            Location location = new Location(LocationManager.GPS_PROVIDER);
            location.setLatitude(place.getLatLng().latitude);
            location.setLongitude(place.getLatLng().longitude);
            Mascota mascota = new Mascota(cosa.getMascotas().size(), nombre, descripcion, colour, null, usuario);
            Alertas alerta = new Alertas(cosa.getAlertas().size(), mascota, location, rango);
            cosa.nuevaAlerta(alerta);
            Intent intent = new Intent(this,Perdidos.class);
            intent.putExtra("cosa",cosa);
            startActivity(intent);
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Por favor elija un lugar válido");
            builder.show();
        }
    }
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                place = PlacePicker.getPlace(this, data);
                String endMsg = String.format("Place: %s",place.getName());
                Toast.makeText(this,endMsg,Toast.LENGTH_LONG).show();
                onResult();
            }
        }
    }
}
