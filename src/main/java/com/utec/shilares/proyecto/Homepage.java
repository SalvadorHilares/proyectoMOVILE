package com.utec.shilares.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {

    double diner = 20.00;
    ArrayList<String> products = new ArrayList<String>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
    }

    public void Recharge(View view){
        EditText money_recharge = findViewById(R.id.recharge);
        String new_money = money_recharge.getText().toString();
        diner = diner + Double.parseDouble(new_money);
        if(diner > 10000){
            Toast.makeText(this,"You can't recharge more than 10000 soles",Toast.LENGTH_SHORT).show();
            Log.w(this.getClass().getName(),"LimitPass:failure");
            return ;
        }
        displayMoney(diner);
    }

    private void displayMoney(double number){
        TextView money_actual = findViewById(R.id.money_actual);
        money_actual.setText("Dinero actual: "+number+" soles");
    }

    public void Post(View view){
        EditText name_product = findViewById(R.id.name_product);
        EditText price_product = findViewById(R.id.price_product);
        EditText character = findViewById(R.id.characters_product);
        EditText hi = findViewById(R.id.time_init_product);
        EditText hf = findViewById(R.id.time_final_product);

        String name = name_product.getText().toString();
        String price = price_product.getText().toString();
        String cha = character.getText().toString();
        String hinicio = hi.getText().toString();
        String hfinal = hf.getText().toString();

        if (name.isEmpty() || price.isEmpty() || cha.isEmpty() || hinicio.isEmpty() || hfinal.isEmpty()){
            Toast.makeText(this, "Por favor, rellenar todos los campos", Toast.LENGTH_SHORT).show();
            Log.w(this.getClass().getName(),"NotYetALLTarget:failure");
        }else {

            products.add(name);
            products.add(price);
            products.add(cha);
            products.add(hinicio);
            products.add(hfinal);

            TextView display_products = findViewById(R.id.my_products);
            TextView place_products = findViewById(R.id.place_proucts);

            int size = 0;
            StringBuilder final_text = new StringBuilder();

            for (int i = 0; i < products.size(); i++) {
                final_text.append(products.get(i)).append("\n");
                size += 1;
            }

            size = size/5;

            place_products.setText("Cantidad de productos posteados :"+size);
            display_products.setText(final_text);
        }
    }

    public void Logout(View view){
        startActivity(new Intent(Homepage.this, Login.class));
        finish();
    }
}