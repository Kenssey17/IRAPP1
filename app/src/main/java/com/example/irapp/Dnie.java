package com.example.irapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;


public class Dnie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnie);
    }

    //**************metodos barra de tareas***************************
    //Método para el botón contactenos y dirigue a la app WhatsApp

    public void contactenos(View view){
        String numero= "+573118474875";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_VIEW);
        String uri = "whatsapp://send?phone="+numero;
        sendIntent.setData(Uri.parse(uri));
        startActivity(sendIntent);
    }



    public void miEspacio(View view){
        Intent intent = new Intent(view.getContext(), MiEspacio.class);
        startActivity(intent);
    }

    public void iniciarSesion(View view){
        Toast.makeText(getApplicationContext(), "Ya iniciaste sesión!", Toast.LENGTH_SHORT).show();

    }
//************************************

    //Método para pasar a la activity escoge tu perfil.
    public void construccion(View view){
        Intent intent = new Intent(view.getContext(), EnConstruccion.class);
        startActivity(intent);
    }

    public void ascensor(View view){
        Intent intent = new Intent(view.getContext(), Ascensor1.class);
        startActivity(intent);
    }

    public void publicaciones(View view){
        Intent intent = new Intent(view.getContext(), Publicaciones.class);
        startActivity(intent);
    }

    public void lineas(View view){
        Intent intent = new Intent(view.getContext(), LineasInvestigacion.class);
        startActivity(intent);
    }


}