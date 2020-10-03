package com.example.gestiondestock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ListView mylist=findViewById(R.id.listview6);
        dbProducts db=new dbProducts(Main6Activity.this);

        String prix_max=getIntent().getStringExtra("prix_max");
        String prix_min=getIntent().getStringExtra("prix_inf");

        ArrayList<product> arrayList=db.search_prix(prix_min,prix_max);
        productadapter productadapter=new productadapter(this,R.layout.product_item,arrayList);

        mylist.setAdapter(productadapter);
    }
}
