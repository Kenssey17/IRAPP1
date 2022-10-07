package com.example.irapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Entidades.Usuario;

public class CrearUsuario extends AppCompatActivity {

    private TextView crearCuenta;
    private EditText usuario, correo, contrasena, confircontrasena;
    private ImageView flechaRegistro;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ProgressDialog cargando;

    Usuario usu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_usuario);

        //Método llamado donde se inicializa con Firebase.
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        cargando = new ProgressDialog(this);
        usu = new Usuario();

        crearCuenta = (TextView) findViewById(R.id.textViewRegistrarse);
        usuario = (EditText) findViewById(R.id.Editusuario);
        correo = (EditText) findViewById(R.id.Editcorreo);
        contrasena = (EditText) findViewById(R.id.Editcontrasena);
        confircontrasena = (EditText) findViewById(R.id.EditconfirmarContrasena);
        flechaRegistro = (ImageView) findViewById(R.id.imageView25);

        flechaRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validar()==true){
                    Registrar();

                }
            }
        });

    }

    private void Registrar(){
        String nombre = usuario.getText().toString();
        String email = correo.getText().toString();
        String password = contrasena.getText().toString();
        String password2 = confircontrasena.getText().toString();

        //Verificamos que las cajas de texto no esten vacías.
        if (TextUtils.isEmpty(nombre) || nombre.length() < 5) {
            showError(usuario,"Nombre no valido");
            return;
        }else if (TextUtils.isEmpty(email) || !email.contains("@cun.edu.co")) {
            showError(correo,"Correo Electrónico no valido");
            return;
        }else if (TextUtils.isEmpty(password) || password.length() < 6) {
            showError(contrasena,"Contraseña no valida, mínimo 6 carácteres");
            return;
        }else if (TextUtils.isEmpty(password2)) {
            showError(confircontrasena,"Contraseña no valida, no coincide.");
            return;
        }

        if (password.equals(password2)) {
            Usuario u = new Usuario();
            u.setUid(UUID.randomUUID().toString());
            u.setUsuario(nombre);
            u.setCorreo(email);
            u.setContrasena(password);

            cargando.dismiss();
            databaseReference.child("Usuarios").child(u.getUid()).setValue(u);
            Toast.makeText(getApplicationContext(), "Usuario creado con exito.. ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CrearUsuario.this, IniciarSesion.class);
            startActivity(intent);

        }else {
            cargando.dismiss();
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }


    }

    //Metodo de la validación de las cajas de texto del Login.
    private void showError(EditText input, String s){
        input.setError(s);
        input.requestFocus();
    }

    boolean Validar() {

        if (usuario.getText().toString().equals("") == false) {
            if (correo.getText().toString().equals("") == false) {
                if (contrasena.getText().toString().equals("") == false) {
                     if (confircontrasena.getText().toString().equals("") == false) {
                         return true;
                     }else{
                         Toast.makeText(getApplicationContext(), "Confirme la contraseña", Toast.LENGTH_SHORT).show();
                     }
                }else {
                    Toast.makeText(getApplicationContext(), "Ingrese la contraseña", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getApplicationContext(), "Ingrese el correo eléctronico", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getApplicationContext(), "Ingrese el usuario", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


    //Se controla la pulsación de la flecha atrás.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==event.KEYCODE_BACK){
            Intent i = new Intent(this, IniciarSesion.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();
        }

        return super.onKeyDown(keyCode, event);
    }

    
}