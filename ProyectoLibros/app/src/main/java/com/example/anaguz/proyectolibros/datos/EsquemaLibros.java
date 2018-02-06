package com.example.anaguz.proyectolibros.datos;

import android.provider.BaseColumns;

/**
 * Created by anaguz on 6/02/18.
 * Esquema de la base de datos para libros
 */

public class EsquemaLibros {
    public static final class LawyerEntry implements BaseColumns {
        /*LawyerEntry es una clase interna para guardar el nombre de las columnas de las tablas*/
        public static final String TABLE_NAME ="libros";

        public static final String TITULO = "titulo";
        public static final String GENERO = "genero";
        public static final String AUTOR = "autor";
        public static final String ISBN = "isbn";
        public static final String SIPNOSIS = "sipnosis";
        public static final String PRESTADO = "prestado";
        public static final String PORTADA = "portada";

        private LawyerEntry(){}



    }
}
