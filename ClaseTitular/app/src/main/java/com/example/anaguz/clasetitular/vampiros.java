package com.example.anaguz.clasetitular;

import java.io.Serializable;

/**
 * Created by anaguz on 20/10/17.
 */

public class vampiros implements Serializable{

    private String nombre;
    private String apellidos;
    private int imagen;

    public vampiros (String tit, String sub, int im){

        nombre = tit;
        apellidos = sub;
        imagen = im;
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


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
