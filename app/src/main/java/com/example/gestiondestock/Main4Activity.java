package com.example.gestiondestock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class Main4Activity extends AppCompatActivity {
    Button BtnSearch_id,BtnSearch_libelle;
    dbProducts db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        final EditText libelle=findViewById(R.id.libel1);
        final EditText id=findViewById(R.id.id_request);
        BtnSearch_id=findViewById(R.id.search_butt_id);
        BtnSearch_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main4Activity.this, "Search in progress", Toast.LENGTH_LONG).show();
                Intent myintent=new Intent(Main4Activity.this,Main3Activity.class);
                myintent.putExtra("id",id.getText().toString());
                startActivity(myintent);

            }
        });
        BtnSearch_libelle=findViewById(R.id.search_button_libellee);
        BtnSearch_libelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main4Activity.this, "Search in progress", Toast.LENGTH_LONG).show();
                Intent myintent=new Intent(Main4Activity.this,Main5Activity.class);
                myintent.putExtra("libelle",libelle.getText().toString());
                startActivity(myintent);

            }
        });
        final EditText prix_max=findViewById(R.id.prix_max);
        final EditText prix_min=findViewById(R.id.prix_inf);
                Button BtnSearch_price=findViewById(R.id.search_button_price);
       BtnSearch_price.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(Main4Activity.this, "Search in progress", Toast.LENGTH_LONG).show();
               Intent myintent=new Intent(Main4Activity.this,Main6Activity.class);
               myintent.putExtra("prix_inf",prix_min.getText().toString());
               myintent.putExtra("prix_max",prix_max.getText().toString());
               startActivity(myintent);
           }
       });


    }
}
