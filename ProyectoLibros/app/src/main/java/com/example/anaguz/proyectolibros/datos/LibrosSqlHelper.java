package com.example.anaguz.proyectolibros.datos;

/**
 * Created by anaguz on 6/02/18.
 */

public class LibrosSqlHelper {

    public static final String[] ARRAY_TABLAS = {
            LibroEntry.TABLE_NAME,
            ...
    }

    // on create
    for(tabla : ARRAY_TABLAS) {
            sql.exeqsql(tabla);
            }

}
