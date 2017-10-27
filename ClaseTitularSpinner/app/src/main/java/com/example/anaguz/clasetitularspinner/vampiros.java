package com.example.anaguz.clasetitularspinner;

import java.io.Serializable;

/**
 * Created by anaguz on 20/10/17.
 */

public class vampiros {

    private String nombre;
    private String apellidos;
    private int Edad;
    private int imagen;

    public vampiros(String tit, String sub,int eda, int im){

        nombre = tit;
        apellidos = sub;
        imagen = im;
        Edad=eda;
    }

    public String getNombre(){

        return nombre;
    }

    public String getApellidos(){

        return apellidos;
    }

    public int getImagen(){

        return imagen;
    }

    public int getEdad() {
        return Edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
