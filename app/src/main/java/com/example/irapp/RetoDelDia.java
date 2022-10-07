package com.example.irapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class RetoDelDia extends AppCompatActivity {

    private ImageView iniciosesion, chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reto_del_dia);

        iniciosesion= (ImageView) findViewById(R.id.imageAscensorPerfil);


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

    //Método para pasar a la activity escoge tu perfil.
    public void iniciarSesion(View view){
        Toast.makeText(getApplicationContext(), "Ya iniciaste sesión!", Toast.LENGTH_SHORT).show();
    }

    public void miEspacio(View view){
        Intent intent = new Intent(view.getContext(), MiEspacio.class);
        startActivity(intent);
    }

    //Método para pasar a la activity escoge tu perfil.
    public void construccion(View view){
        Intent intent = new Intent(view.getContext(), EnConstruccion.class);
        startActivity(intent);
    }

    public void noticias(View view){
        Intent intent = new Intent(view.getContext(), Noticias.class);
        startActivity(intent);
    }

    public void diarioCampo(View view){
        Intent intent = new Intent(view.getContext(), ProductoDeCampo.class);
        startActivity(intent);
    }

    public void ascensor(View view){
        Intent intent = new Intent(view.getContext(), Ascensor1.class);
        startActivity(intent);
    }

     @Override
    public boolean onKeyDown (int keyCode, KeyEvent event){
        if (keyCode==event.KEYCODE_BACK) {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("¿Desea cerrar sesión?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(RetoDelDia.this, IniciarSesion.class);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    })
                   .setNegativeButton("No", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           dialog.dismiss();
                       }
                   });
                builder.show();
        }

        return super.onKeyDown(keyCode, event);
    }



}