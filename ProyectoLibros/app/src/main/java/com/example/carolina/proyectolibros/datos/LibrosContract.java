package com.example.carolina.proyectolibros.datos;

/**
 * Created by carolina on 10/02/2018.
 */

    import android.provider.BaseColumns;

    /**
     * Created by anaguz on 6/02/18.
     * Esquema de la base de datos para libros
     */

    public class LibrosContract {
        public static final class LibrosEntry implements BaseColumns {
            /*Se implementa la interfaz BaseColumns  para agregar una columna extra
            Se recomienda que la tenga
             */

            //public static final int DATABASE_VERSION = 1;
            //public static final String DATABASE_NAME = "libros.db";

            /*LawyerEntry es una clase interna para guardar el nombre de las columnas de las tablas*/
            public static final String TABLE_NAME ="Libros";

            public static final String ID = "id";
            public static final String TITULO = "titulo";
            public static final String GENERO = "genero";
            public static final String AUTOR = "autor";
            public static final String ISBN = "isbn";
            public static final String SIPNOSIS = "sipnosis";
            public static final String PRESTADO = "prestado";
            public static final String PORTADA = "portada";

            private LibrosEntry(){}



        }
    }


