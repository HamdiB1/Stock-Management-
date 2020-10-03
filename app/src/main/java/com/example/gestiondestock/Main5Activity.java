package com.example.gestiondestock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        dbProducts db = new dbProducts(Main5Activity.this);
        ListView mylist = findViewById(R.id.listview5);
        ArrayList<product> arrayList=new ArrayList<>();
        String libelle=getIntent().getStringExtra("libelle");
        //String id=getIntent().getStringExtra("id");
       /* arrayList=db.search_id(id);*/

            arrayList=db.gettRequest_lib(libelle);


        productadapter productadapter=new productadapter(this,R.layout.product_item,arrayList);

        mylist.setAdapter(productadapter);
    }
}
