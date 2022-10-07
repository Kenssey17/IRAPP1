package com.example.irapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LineasInvestigacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lineas_investigacion);
    }


    //Método para el botón contactenos y dirigue a la app WhatsApp
    public void contactenos(View view){
        String numero= "+573118474875";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_VIEW);
        String uri = "whatsapp://send?phone="+numero;
        sendIntent.setData(Uri.parse(uri));
        startActivity(sendIntent);
    }
    public void ascensor(View view){
        Intent intent = new Intent(view.getContext(), Ascensor1.class);
        startActivity(intent);
    }

    public void miEspacio(View view){
        Intent intent = new Intent(view.getContext(), MiEspacio.class);
        startActivity(intent);
    }

    public void iniciarSesion(View view){
        Toast.makeText(getApplicationContext(), "Ya iniciaste sesión!", Toast.LENGTH_SHORT).show();

    }

}