package com.example.carolina.proyectolibros.datos;

/**
 * Created by carolina on 10/02/2018.
 */
import android.content.ContentValues;
import android.database.Cursor;

import static com.example.carolina.proyectolibros.datos.LibrosContract.LibrosEntry;


import java.util.UUID;

/**
 * Created by anaguz on 6/02/18.
 * Entidad Libros
 */

public class Libros {
/*Atributos de la clase Libros*/
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
    /*Se recibe un cursos, su función es fabricar un nuevo libro*/
    public Libros(Cursor cursor) {
        id = cursor.getString(cursor.getColumnIndex(LibrosEntry.ID));
        titulo = cursor.getString(cursor.getColumnIndex(LibrosEntry.TITULO));
        genero = cursor.getString(cursor.getColumnIndex(LibrosEntry.GENERO));
        autor = cursor.getString(cursor.getColumnIndex(LibrosEntry.AUTOR));
        isbn = cursor.getString(cursor.getColumnIndex(LibrosEntry.ISBN));
        sipnosis = cursor.getString(cursor.getColumnIndex(LibrosEntry.SIPNOSIS));
        prestado = cursor.getString(cursor.getColumnIndex(LibrosEntry.PRESTADO));
        portada = cursor.getString(cursor.getColumnIndex(LibrosEntry.PORTADA));
    }

    /*El Content values es el contenerdor de valores*/
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        /*Pares clave-Valor*/
        values.put(LibrosEntry.ID, id);
        values.put(LibrosEntry.TITULO, titulo);
        values.put(LibrosEntry.GENERO,genero );
        values.put(LibrosEntry.AUTOR,autor );
        values.put(LibrosEntry.ISBN,isbn );
        values.put(LibrosEntry.SIPNOSIS,sipnosis );
        values.put(LibrosEntry.PRESTADO,prestado );
        values.put(LibrosEntry.PORTADA,portada );

        return values;
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