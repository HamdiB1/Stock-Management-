package com.example.gestiondestock;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;



    public class productadapter extends ArrayAdapter<product>{

        private ArrayList<product> myarraylist;
        private Context ctx;
        private int item;


        public productadapter(@NonNull Context context, int resource, ArrayList<product> mydata) {
            super(context, resource, mydata);

            this.myarraylist=mydata;
            this.ctx= context;
            this.item=resource;
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            convertView = LayoutInflater.from(ctx).inflate(item, parent, false);

            //   CircleImageView imageView= convertView.findViewById(R.id.image);

           TextView id=convertView.findViewById(R.id.id1);
            TextView lib= convertView.findViewById(R.id.lib1);
            TextView quantity=convertView.findViewById(R.id.quantity1);
            //TextView reference=convertView.findViewById(R.id.reference);
           TextView price=convertView.findViewById(R.id.price1);

            product modele=getItem(position);

            String str_prix=Integer.toString(modele.getPrix());

            //imageView.setImageResource(modele.getImage());

           id.setText(Integer.toString(modele.getId()));
             lib.setText(modele.getLib());
            quantity.setText((Long.toString( modele.getQuantity())));
            price.setText(str_prix);
            //reference.setText(modele.getReference());

       return convertView;
        }
    }

