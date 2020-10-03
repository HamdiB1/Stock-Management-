package com.example.gestiondestock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    public dbProducts db;
    EditText  lib, quantity,reference,prix,Editid;
    Button b;
    Button BUpdate;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //id = findViewById(R.id.id);
        lib = findViewById(R.id.lib);
        quantity = findViewById(R.id.quantity);
       // reference=findViewById(R.id.reference);
        b = findViewById(R.id.add_button);

        Button BUpdate=findViewById(R.id.update_button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editid=findViewById(R.id.id);
                lib = findViewById(R.id.lib);
                quantity = findViewById(R.id.quantity);
               // reference=findViewById(R.id.reference);
                prix=findViewById(R.id.prix);


             //int ident = Integer.parseInt(Editid.getText().toString());
                String libb = lib.getText().toString();
               int quan = Integer.parseInt(quantity.getText().toString());
                int price=Integer.parseInt(prix.getText().toString());
              //String ref=reference.getText().toString();

                db = new dbProducts(Main2Activity.this);
                product p = new product(libb, quan,price);

                db.InsertMessage(p);

                Toast.makeText(Main2Activity.this, "saved ..!", Toast.LENGTH_SHORT).show();

               Intent myIntent = new Intent(Main2Activity.this, MainActivity.class);
               startActivity(myIntent);


            }
        });

        BUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lib = findViewById(R.id.lib);
                quantity = findViewById(R.id.quantity);
                // reference=findViewById(R.id.reference);
                prix=findViewById(R.id.prix);
                //int ident = Integer.parseInt(Editid.getText().toString());
                String libb = lib.getText().toString();
                int quan = Integer.parseInt(quantity.getText().toString());
                int price=Integer.parseInt(prix.getText().toString());
                // int ref=Integer.parseInt((reference.getText().toString()));

                db = new dbProducts(Main2Activity.this);
                product p = new product(libb, quan,price);
                boolean x=db.updateData(p);
                if (x)
                {
                    Toast.makeText(Main2Activity.this, "updated ..!", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Main2Activity.this,"update failed..!",Toast.LENGTH_LONG).show();

            }
        });

    }


}