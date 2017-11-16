package com.example.anaguz.ejerciciorecopilatorio;

/**
 * Created by anaguz on 14/11/17.
 */

public class Destino {

    
    private String zona;
    private String continente;
    private int Precio;


    public Destino(String zon, String cont, int pre){

        zona = zon;
        continente = cont;
        Precio =pre;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }
}
