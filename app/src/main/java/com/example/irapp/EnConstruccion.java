package com.example.irapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EnConstruccion extends AppCompatActivity {

    private ImageView volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.en_construccion);

        volver = (ImageView) findViewById(R.id.imageView21);



    }

    //Método para pasar a la activity escoge tu perfil.
    public void Volver(View view){
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //codigo adicional
        this.finish();
    }
}