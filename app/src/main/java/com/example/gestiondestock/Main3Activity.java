package com.example.gestiondestock;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    dbProducts db;
    ListView mylist;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        db = new dbProducts(Main3Activity.this);
        ListView mylist = findViewById(R.id.listview3);

       ArrayList<product> arrayList=new ArrayList<>();
        String libelle=getIntent().getStringExtra("libelle");
        String id=getIntent().getStringExtra("id");
        arrayList=db.search_id(id);
        /*if(!libelle.isEmpty())
            arrayList=db.gettRequest_lib(libelle);*/


        productadapter productadapter=new productadapter(this,R.layout.product_item,arrayList);

        mylist.setAdapter(productadapter);


    }
}
