package com.example.anaguz.adaptadorserie;

import java.io.Serializable;

/**
 * Created by anaguz on 28/11/17.
 */

public class Series implements Serializable {

    private String Nombre;
    private String Creador;
    private int Temporadas;

    public Series (String Nombre, String Tema,int Temporadas){

        this.Nombre=Nombre;
        this.Creador =Tema;
        this.Temporadas=Temporadas;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCreador() {
        return Creador;
    }

    public void setCreador(String creador) {
        Creador = creador;
    }

    public int getTemporadas() {
        return Temporadas;
    }

    public void setTemporadas(int temporadas) {
        Temporadas = temporadas;
    }
}
