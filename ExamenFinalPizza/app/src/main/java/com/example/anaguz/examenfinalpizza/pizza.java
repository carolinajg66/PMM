package com.example.anaguz.examenfinalpizza;

import java.io.Serializable;

/**
 * Created by anaguz on 21/11/17.
 */

public class pizza implements Serializable{

    private  String nombre;
    private  String descripcion;
    private  double precio;
    private  int image;

    public pizza (String nombre, String descripcion, double precio, int image){

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.image=image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
