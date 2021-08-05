package com.utec.shilares.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Register extends AppCompatActivity {

    ArrayList<String> clients = new ArrayList<String>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }

    public void register(View view){
        EditText dni = findViewById(R.id.dni);
        EditText username = findViewById(R.id.username);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        String DNI = dni.getText().toString();
        String user = username.getText().toString();
        String Email = email.getText().toString();
        String pass = password.getText().toString();

        if(DNI.length()<8) {
            Toast.makeText(this, "DNI invalido", Toast.LENGTH_SHORT).show();
            if (pass.length() < 4) {
                Toast.makeText(this, "Contraseña invalido", Toast.LENGTH_SHORT).show();
                if (user.length()< 4){
                    Toast.makeText(this, "Nombre de Usuario muy corto", Toast.LENGTH_SHORT).show();
                }
                    if (Email.isEmpty() || user.isEmpty() || pass.isEmpty() || DNI.isEmpty()){
                        Toast.makeText(this, "Por favor, rellenar todos los campos", Toast.LENGTH_SHORT).show();
                    }
            }
        }else{
            clients.add(DNI);
            clients.add(user);
            clients.add(Email);
            clients.add(pass);
            Intent miIntent = new Intent(Register.this, Homepage.class);
            startActivity(miIntent);
        }
    }

}