package com.example.gestiondestock;

public class product {
    private int id;
    String ref;
    private String lib;
    private int quantity;
    private  String reference;
    private  int prix;

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

/*    public product(String lib, int quantity, int prix) {
        this.lib = lib;
        this.quantity = quantity;
        this.prix = prix;
    }*/


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public product(String lib, int quantity) {
        this.lib = lib;
        this.quantity = quantity;
    }

    public product(String lib, int quantity, String reference){
        this.lib = lib;
        this.quantity = quantity;
        this.reference=reference;
}
    public product() {
    }

    public void setId(int id) {
        this.id = id;
    }

   /* public product(int id, String lib, int quantity) {
        this.id = id;
        this.lib = lib;
        this.quantity = quantity;
    }*/

    public product(String lib, int quantity, int prix) {
        this.lib = lib;
        this.quantity = quantity;
        this.prix = prix;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getLib() {
        return lib;
    }

    public long getQuantity() {
        return quantity;
    }

    public product(int id, String lib, int quantity,int prix) {
        this.id = id;
        this.lib = lib;
        this.quantity = quantity;
        this.prix=prix;
    }
}
