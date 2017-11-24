package com.example.anaguz.examenfinalpizza;

import java.io.Serializable;

/**
 * Created by anaguz on 21/11/17.
 */

public class pizza implements Serializable{

    private  String nombre;
    private  String descripcion;
    private  double precio;

    public pizza (String nombre, String descripcion, double precio){

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
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
