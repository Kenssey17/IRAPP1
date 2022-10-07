package com.example.irapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MiEspacio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mi_espacio);
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

      //Método para pasar a la activity escoge tu perfil.
    public void iniciarSesion(View view){
        Toast.makeText(getApplicationContext(), "Ya iniciaste sesión!", Toast.LENGTH_SHORT).show();
    }

    public void miEspacio(View view){
        Intent intent = new Intent(view.getContext(), MiEspacio.class);
        startActivity(intent);
    }

    //Método para pasar a la activity escoge tu perfil.
    public void Construccion(View view){
        Intent intent = new Intent(view.getContext(), EnConstruccion.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //codigo adicional
        this.finish();
    }



}