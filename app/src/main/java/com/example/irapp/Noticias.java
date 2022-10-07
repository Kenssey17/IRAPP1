package com.example.irapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class Noticias extends AppCompatActivity {

    List<CarouselItem> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticias);

        ImageCarousel carousel = findViewById(R.id.carouselNoticias);
        carousel.registerLifecycle(getLifecycle());

        //metodo para las imagenes de las noticias

// Imagenes del CarouselItem
        list.add(
                new CarouselItem(
                        R.drawable.ejemplo1,
                        "Ejemplo 1"
                )
        );

        list.add(
                new CarouselItem(
                        R.drawable.ejemplo2,
                        "Ejemplo 2"

                )
        );

        list.add(
               new CarouselItem(
                       R.drawable.ejemplo3,
                       "Ejemplo 3"
               )
        );

        carousel.setData(list);
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
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Se controla la pulsación de la flecha atrás.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==event.KEYCODE_BACK){
            Intent i = new Intent(this, PisoAcademico.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();
        }

        return super.onKeyDown(keyCode, event);
    }
}