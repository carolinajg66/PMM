package com.example.anaguz.proyectolibros.datos;

import java.util.UUID;

/**
 * Created by anaguz on 6/02/18.
 * Entidad Libros
 */


public class Libros {

    private String id;
    private String titulo;
    private String genero;
    private String autor;
    private String isbn;
    private String sipnosis;
    private String prestado;
    private String portada;


    public Libros(String titulo, String genero,
                  String autor, String isbn, String sipnosis,
                  String prestado, String portada) {

        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.genero=genero;
        this.autor=autor;
        this.isbn=isbn;
        this.sipnosis=sipnosis;
        this.prestado=prestado;
        this.portada=portada;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public String getPrestado() {
        return prestado;
    }

    public String getPortada() {
        return portada;
    }
}
