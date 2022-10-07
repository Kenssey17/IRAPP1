package com.example.irapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //private ImageView fondo, entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fondo = (ImageView) findViewById(R.id.imageInicioFondo);
        //entrar = (ImageView) findViewById(R.id.imageInicioEntrar);



    }

    //Método para pasar a la activity escoge tu perfil.
    public void EscogePerfil(View view){
        Intent intent = new Intent(view.getContext(), EscogeTuPerfil.class);
        startActivity(intent);
    }

    //Se controla la pulsación de la flecha atrás.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==event.KEYCODE_BACK){
            finish();
        }

        return super.onKeyDown(keyCode, event);
    }

   /* @Override
    public boolean onKeyDown (int keyCode, KeyEvent event){
        if (keyCode==event.KEYCODE_BACK) {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir de la App?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent=new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    })
                   .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           dialog.dismiss();
                       }
                   });
                builder.show();
        }

        return super.onKeyDown(keyCode, event);
    }*/



}