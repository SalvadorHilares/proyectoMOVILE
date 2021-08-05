package com.utec.shilares.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void login(View view){
        //1.  Obtener los datos del Layout
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        String user = username.getText().toString();
        String pass = password.getText().toString();
        if(!user.isEmpty() && !pass.isEmpty()){
            Intent miIntent = new Intent(Login.this, Homepage.class);
            startActivity(miIntent);
            finish();
        }
        else{
            Log.w(this.getClass().getName(), "signInWithUsername:failure");
            Log.w(this.getClass().getName(),"signInWithPassword:failure");
            Toast.makeText(Login.this, "No se pudo iniciar sesión.", Toast.LENGTH_SHORT).show();
        }
    }

    public void Registrar(View view){
        Intent miIntent = new Intent(Login.this, Register.class);
        if (miIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(miIntent);
        }
    }

}