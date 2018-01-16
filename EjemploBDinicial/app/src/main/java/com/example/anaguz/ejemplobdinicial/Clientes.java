package com.example.anaguz.ejemplobdinicial;

/**
 * Created by anaguz on 16/01/18.
 */

public class Clientes {

    private String nombre;
    private String telefono;

    public Clientes (String nom, String tele){
        nombre=nom;
        telefono=tele;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
