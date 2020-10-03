package com.example.gestiondestock;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    dbProducts db;
    ListView mylist;
    ArrayList<product> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db =new dbProducts(MainActivity.this);

        ArrayList<product> arrayList= db.getAllMessage();
        mylist = findViewById(R.id.listview);

        productadapter productadapter=  new productadapter(this, R.layout.product_item , arrayList);

        mylist.setAdapter(productadapter);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("supression")
                        .setMessage("Voulez vous supprimer ce produit?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                ArrayList<product> arrayList=db.getAllMessage();

                                db.DeleteProduct(arrayList.get(position).getId());
                                arrayList=db.getAllMessage();

                                productadapter productadapter=new productadapter(MainActivity.this,R.layout.product_item,arrayList);


                                mylist.setAdapter(productadapter);

}})
        .setNegativeButton(android.R.string.no, null)
        .setIcon(android.R.drawable.ic_dialog_alert)
        .show();


        }

        }     );




        }

@Override
public void onResume()
        {
            super.onResume();
            ArrayList<product> arrayList=db.getAllMessage();
            productadapter productadapter=new productadapter(MainActivity.this,R.layout.product_item,arrayList);
            mylist.setAdapter(productadapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if( item.getItemId()==R.id.add_button)
        {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class); startActivity(intent);
        }

        if( item.getItemId()==R.id.search_button)
        {
            Intent intent = new Intent(MainActivity.this, Main4Activity.class); startActivity(intent);
        }
        return true ;
    }

}
