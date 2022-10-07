package com.example.irapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;



public class Ascensor1 extends AppCompatActivity {


    private ImageView displayAscensor;
    private ImageView botonAscensor1;
    private ImageView botonAscensor2;
    private ImageView botonAscensor3;
    private ImageView botonAscensor4;
    private ImageView botonAscensor5;
    private ImageView botonAscensor6;
    private ImageView botonAscensor7;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ascensor1);

        displayAscensor = (ImageView) findViewById(R.id.imageAscensorDisplay);
        botonAscensor1 = (ImageView) findViewById(R.id.imageAscensor1);
        botonAscensor2 = (ImageView) findViewById(R.id.imageAscensor2);
        botonAscensor3 = (ImageView) findViewById(R.id.imageAscensor3);
        botonAscensor4 = (ImageView) findViewById(R.id.imageAscensor4);
        botonAscensor5 = (ImageView) findViewById(R.id.imageAscensor5);
        botonAscensor6 = (ImageView) findViewById(R.id.imageAscensor6);
        botonAscensor7 = (ImageView) findViewById(R.id.imageAscensor7);



    }
    //------------------Metodos iconos especiales-------------------------

    //Método para el botón contactenos y dirige a la app WhatsApp
    public void contactenos(View view){
        String numero= "+573118474875";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_VIEW);
        String uri = "whatsapp://send?phone="+numero;
        sendIntent.setData(Uri.parse(uri));
        startActivity(sendIntent);
    }
    //Metodo para boton mi espacio
    public void miEspacio(View view){
        Intent intent = new Intent(view.getContext(), MiEspacio.class);
        startActivity(intent);
    }

    //Método para pasar a la activity escoge tu perfil.
    public void iniciarSesion(View view){
        Toast.makeText(getApplicationContext(), "Ya iniciaste sesión!", Toast.LENGTH_SHORT).show();

    }


    //------------------------ Metodos Ascensor ----------------------------

    //Metodo #1 Recepcion (Reto del dia)
    public void recepcion(View view){
        botonAscensor1.setImageResource(R.drawable.recurso_123);
        displayAscensor.setImageResource(R.drawable.recurso_116);
        Intent intent = new Intent(view.getContext(), RetoDelDia.class);
        startActivity(intent);
    }

    public void investigacion(View view){
        botonAscensor2.setImageResource(R.drawable.recurso_122);
        displayAscensor.setImageResource(R.drawable.recurso_115);
        Intent intent;
        intent = new Intent(view.getContext(), Dnie.class);
        startActivity(intent);
    }

    public void innovacion(View view){
        botonAscensor3.setImageResource(R.drawable.recurso_121);
        displayAscensor.setImageResource(R.drawable.recurso_114);
        Intent intent = new Intent(view.getContext(), EnConstruccion.class);
        startActivity(intent);
    }

    //Metodo #4 Academico
    public void aprendizaje(View view){
        botonAscensor4.setImageResource(R.drawable.recurso_120);
        displayAscensor.setImageResource(R.drawable.recurso_113);
        Intent intent = new Intent(view.getContext(), PisoAcademico.class);
        startActivity(intent);
    }

    public void finanzas(View view) {
        botonAscensor5.setImageResource(R.drawable.recurso_119);
        displayAscensor.setImageResource(R.drawable.recurso_112);
        Intent intent = new Intent(view.getContext(), EnConstruccion.class);
        startActivity(intent);

    }

    public void cocreacion(View view) {
        botonAscensor6.setImageResource(R.drawable.recurso_118);
        displayAscensor.setImageResource(R.drawable.recurso_111);
        Intent intent = new Intent(view.getContext(), EnConstruccion.class);
        startActivity(intent);

    }

    public void preguntas(View view) {
        botonAscensor7.setImageResource(R.drawable.recurso_117);
        displayAscensor.setImageResource(R.drawable.recurso_109);
        Intent intent = new Intent(view.getContext(), EnConstruccion.class);
        startActivity(intent);

    }


            //Metodo #8 para salir
    public void salir(View view){
        Intent intent = new Intent(view.getContext(), EscogeTuPerfil.class);
        startActivity(intent);
    }


    //Método para pasar a pantalla en contruccion
    public void construccion(View view){
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
            Intent i = new Intent(this, RetoDelDia.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();
        }

        return super.onKeyDown(keyCode, event);
    }

}