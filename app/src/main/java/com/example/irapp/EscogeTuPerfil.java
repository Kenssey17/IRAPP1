package com.example.irapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class EscogeTuPerfil extends AppCompatActivity {

    private ImageView estudiantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escoge_tu_perfil);

        estudiantes = (ImageView) findViewById(R.id.imageView10);

    }

    //Método para pasar a la activity escoge tu perfil.
    public void RetoDelDia(View view){
        Intent intent = new Intent(view.getContext(), IniciarSesion.class);
        startActivity(intent);
    }
    //Método para pasar a la activity escoge tu perfil.
    public void Construccion(View view){
        Intent intent = new Intent(view.getContext(), EnConstruccion.class);
        startActivity(intent);
    }

    //Método de regresar, flecha atrás.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent regresar = new Intent(this, MainActivity.class);
                startActivity(regresar);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Se controla la pulsación de la flecha atrás.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==event.KEYCODE_BACK){
            Intent i = new Intent(this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
        }

        return super.onKeyDown(keyCode, event);
    }



}