package com.example.irapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Entidades.Usuario;

public class IniciarSesion extends AppCompatActivity {

    private TextView eresNuevo, olvidasteContrasena, registrateAqui, pulsaAqui;
    private EditText correo, contrasena;
    private Button iniciarSesion;




    DatabaseReference reference;
    FirebaseDatabase firebaseDatabase;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciar_sesion);

        usuario = new Usuario();
        //Método llamado donde se inicializa con Firebase.
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference();


        eresNuevo = (TextView) findViewById(R.id.EresNuevo);
        olvidasteContrasena = (TextView) findViewById(R.id.OlvidasteContrasena);
        registrateAqui = (TextView) findViewById(R.id.RegistrateAqui);
        pulsaAqui = (TextView) findViewById(R.id.PulsaAqui);
        correo = (EditText) findViewById(R.id.correoElectronico);
        contrasena = (EditText) findViewById(R.id.Editcontrasena);
        iniciarSesion = (Button) findViewById(R.id.buttonIniciarSesion);



        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = correo.getText().toString().trim();
                String password = contrasena.getText().toString().trim();

                if (TextUtils.isEmpty(email) || !email.contains("@cun.edu.co")) {
                    showError(correo, "Correo Electrónico no valido");
                    // Toast.makeText(this, "Ingrese el Correo Electrónico", Toast.LENGTH_LONG).show();
                    return;
                }else if (TextUtils.isEmpty(password)) {
                    showError(contrasena, "Contraseña invalida");
                    //Toast.makeText(this, "Ingrese la Contraseña", Toast.LENGTH_LONG).show();
                    return;
                }

                Toast.makeText(IniciarSesion.this,"Ha iniciado sesión..", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(IniciarSesion.this, RetoDelDia.class);
                startActivity(intent);

            }
        });





    }
   /* public void login (View view){
        String email = correo.getText().toString().trim();
        String password = contrasena.getText().toString().trim();

        if (TextUtils.isEmpty(email) || !email.contains("@cun.edu.co")) {
            showError(correo, "Correo Electrónico no valido");
            // Toast.makeText(this, "Ingrese el Correo Electrónico", Toast.LENGTH_LONG).show();
            return;
        }else if (TextUtils.isEmpty(password)) {
            showError(contrasena, "Contraseña invalida");
            //Toast.makeText(this, "Ingrese la Contraseña", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            reference = FirebaseDatabase.getInstance().getReference().child("Usuarios");
            reference.child(email).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Usuario usuario = dataSnapshot.getValue(Usuario.class);
                    if (password.equals(usuario.getContrasena())){
                        Toast.makeText(IniciarSesion.this,"Ha iniciado sesión..", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(IniciarSesion.this, RetoDelDia.class);
                        startActivity(intent);

                    }else {
                        Toast.makeText(IniciarSesion.this,"Contraseña incorrecta..", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }catch (Exception ex){
            Toast.makeText(IniciarSesion.this,
                    "Usuario no registrado..", Toast.LENGTH_LONG).show();

            ex.printStackTrace();

        }





    }*/


    //Metodo de la validación de las cajas de texto del Login.
    private void showError(EditText input, String s){
        input.setError(s);
        input.requestFocus();
    }

    public void RegistrateAqui(View view){
        Intent intent = new Intent(view.getContext(), CrearUsuario.class);
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