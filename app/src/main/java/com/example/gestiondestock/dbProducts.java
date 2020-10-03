package com.example.gestiondestock;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.annotation.Nullable;

import com.example.gestiondestock.product;

import java.util.ArrayList;

public class dbProducts extends SQLiteOpenHelper {
    public dbProducts(@Nullable Context context) {
        super(context, "products", null, 1); //dbmsg esm el base mte3na

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create="Create table products (id integer PRIMARY KEY, Lib TEXT ,quantity integer,prix integer)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String delete ="DROP TABLE IF EXISTS pAD";

        db.execSQL(delete);

        onCreate(db);

    }

    public void InsertMessage(product product){
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values=new ContentValues();
       // values.put("id", product.getId());
        values.put("Lib", product.getLib());
        values.put("quantity", product.getQuantity());
        values.put("prix",product.getPrix());
        //values.put("reference",product.getReference());
       db.insert("products",null,  values );
    }

    public void DeleteProduct(int id)
    {
        SQLiteDatabase db=getWritableDatabase();

        db.delete("products","id="+Integer.toString(id),null);

    }



    public ArrayList<product> getAllMessage(){
        SQLiteDatabase db= getReadableDatabase();

        ArrayList<product> array= new ArrayList<product>();
        String res="SELECT * FROM products ";
        Cursor cursor= db.rawQuery(res, null);

            if (cursor.moveToFirst()) {
                do {
                    product m = new product();
                     m.setId(cursor.getInt(cursor.getColumnIndex("id")));

                    m.setLib(cursor.getString(cursor.getColumnIndex("Lib")));
                    m.setQuantity(cursor.getInt(cursor.getColumnIndex("quantity")));
                      m.setPrix(cursor.getInt(cursor.getColumnIndex("prix")));

                    array.add(m);

                } while (cursor.moveToNext());
            }
            cursor.close();
        return  array;


    }

    public ArrayList<product> gettRequest_lib (String libell){
        SQLiteDatabase db= getReadableDatabase();

        ArrayList<product> array= new ArrayList<product>();
        String res="SELECT * FROM products WHERE Lib='"+libell+"'";
        Cursor cursor= db.rawQuery(res, null);

        if (cursor.moveToFirst()) {
            do
            {
                product m = new product();
                m.setId(cursor.getInt(cursor.getColumnIndex("id")));
                m.setLib(cursor.getString(cursor.getColumnIndex("Lib")));
                m.setQuantity(cursor.getInt(cursor.getColumnIndex("quantity")));
                m.setPrix(cursor.getInt(cursor.getColumnIndex("prix")));
          //  m.setReference(cursor.getString(cursor.getColumnIndex("reference")));
                array.add(m);

            }
            while (cursor.moveToNext());


        }

        cursor.close();
        return  array;


    }


    public boolean updateData(product product)
    {
        SQLiteDatabase db= getReadableDatabase();
        ContentValues values=new ContentValues();
        //values.put("id", product.getId());
        values.put("Lib", product.getLib());
        values.put("quantity", product.getQuantity());
        values.put("prix", product.getPrix());
        String where = "Lib=?";
        String[] whereArgs = new String[] {String.valueOf(product.getLib())};

        db.update("products", values, where, whereArgs);
        //db.update("products",values,"id = ? ",null);

        return true;
    }

    public  ArrayList<product> search_id (String p)
    {
        SQLiteDatabase db=getReadableDatabase();
        ArrayList<product> array= new ArrayList<product>();
        String res="SELECT * from products WHERE id="+p;

        Cursor cursor=db.rawQuery(res,null);
        if (cursor.moveToFirst()) {
            do {
                product m = new product();
                m.setId(cursor.getInt(cursor.getColumnIndex("id")));
                m.setLib(cursor.getString(cursor.getColumnIndex("Lib")));
                m.setQuantity(cursor.getInt(cursor.getColumnIndex("quantity")));
                m.setPrix(cursor.getInt(cursor.getColumnIndex("prix")));

                array.add(m);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return  array;


    }

    public  ArrayList<product> search_prix (String p_min,String p_max)
    {
        SQLiteDatabase db=getReadableDatabase();
        ArrayList<product> array= new ArrayList<product>();
        String res="SELECT * from products WHERE prix>"+p_min+" AND prix<"+p_max;

        Cursor cursor=db.rawQuery(res,null);
        if (cursor.moveToFirst()) {
            do {
                product m = new product();
                m.setId(cursor.getInt(cursor.getColumnIndex("id")));

                m.setLib(cursor.getString(cursor.getColumnIndex("Lib")));
                m.setQuantity(cursor.getInt(cursor.getColumnIndex("quantity")));
                m.setPrix(cursor.getInt(cursor.getColumnIndex("prix")));

                array.add(m);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return  array;


    }




}