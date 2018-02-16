package com.example.carolina.proyectolibros.datos;

/**
 * Created by carolina on 10/02/2018.
 */

 import android.content.Context;
 import android.database.Cursor;
 import android.database.sqlite.SQLiteDatabase;
 import android.database.sqlite.SQLiteOpenHelper;

 import static com.example.carolina.proyectolibros.datos.LibrosContract.LibrosEntry;


/*Conexión  de la aplicación con la base de datos con la axtensión SQLiteOpenHelper*/

public class LibrosSqlHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Libros.db";
    /*Libros.db es  el nombre de la base de datos*/

    public LibrosSqlHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + LibrosContract.LibrosEntry.TABLE_NAME + " ("
                + LibrosEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + LibrosEntry.ID + " TEXT NOT NULL,"
                + LibrosEntry.TITULO + " TEXT NOT NULL,"
                + LibrosEntry.GENERO+ " TEXT NOT NULL,"
                + LibrosEntry.AUTOR + " TEXT NOT NULL,"
                + LibrosEntry.ISBN + " TEXT NOT NULL,"
                + LibrosEntry.SIPNOSIS + " TEXT NOT NULL,"
                + LibrosEntry.PRESTADO + " TEXT ,"
                + LibrosEntry.PORTADA + " TEXT,"
                + "UNIQUE (" + LibrosEntry.ID + "))");

/*Tiene dos Id por que  el framework de Android usa el BaseColumns._ID, en nuestro caso lo llamamos LibrosEntry._ID
 Esta referencia esta internamente en varios procesos*/

        // Insertar datos para prueba inicial
        mockData(sqLiteDatabase);

    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockLibros(sqLiteDatabase, new Libros("Mansfield Park", "Novela de aprendizaje",
                "Jane Austen", "111444777",
                "Fanny Price es aún una niña cuando sus tíos la acogen " +
                        "en su mansión de Mansfield Park, rescatándola de una vida de estrecheces " +
                        "y de necesidades.",
                "si", "mansfield.jpg"));
        mockLibros(sqLiteDatabase, new Libros("Cazadores de sombras: ciudad de huesos","Fantasia",
                "Cassandra Clare", "300222112",
                "En el Pandemonium, la discoteca de moda de Nueva York, Clary sigue a un atractivo " +
                        "chico de pelo azul hasta que presencia su muerte a manos de tres jóvenes cubiertos de " +
                        "extraños tatuajes.","no","ciudad.jpg" ));
        mockLibros(sqLiteDatabase, new Libros("El castillo ambulante", "Fantasia",
                " Diana Wynne Jones", "222555888.",
                "En el país de Ingary, donde las botas de siete leguas y las capas de invisibilidad existen " +
                        "de verdad, Sophie Hatter ha atraído la desagradable" +
                        " atención de la Bruja del Páramo, quién la hechiza con un maleficio que la" +
                        " convierte en una anciana. ","si","castillo.jpg"));
        mockLibros(sqLiteDatabase, new Libros("Los pilares de la Tierra", "Novela histórica",
                "Ken Follett", "333666999",
                "La novela empieza con la historia de Tom Builder y su familia, Tom es un albañil que se " +
                        "vuelve pobre al perder su trabajo de constructor en " +
                        "una casa para el hijo de un noble, William Hamleigh. Agnes, su esposa," +
                        " da a luz en un bosque y muere. ","si","pilares.jpg"));
        mockLibros(sqLiteDatabase, new Libros("Harry Potter y la piedra filosofal","Fantasia",
                " J. K. Rowling", "555888666",
                "Harry Potter crece en la casa de sus tíos, los Dursley, quienes le ocultan su verdadera historia" +
                        " familiar; al cumplir Harry once años de edad, empiezan a llegarle " +
                        "cartas de remitente desconocido, que van aumentando en número a medida que sus tíos" +
                        " no dejan que las abra.","si","potterpiedra.jpeg"));
        mockLibros(sqLiteDatabase, new Libros("Harry Potter y la camara secreta  ", "Fantasia",
                " J. K. Rowling", "666555448",
                "Tras el primer curso de Harry en Hogwarts, éste regresa al hogar de sus tíos Vernon" +
                        " y Petunia Dursley para pasar el verano allí. ","no","pottercamara.jpeg"));

    }

    public long mockLibros(SQLiteDatabase db, Libros libros) {
        return db.insert(
                LibrosEntry.TABLE_NAME,
                null,
                libros.toContentValues());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
        /*Se utilza si la base de datoa tiene una versión antigua*/
    }

    /*Metodo para guardar los libros*/
    public long saveLibros(Libros libros) { /*Este metodo recibe una instancia libro*/
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                LibrosEntry.TABLE_NAME,
                null,
                libros.toContentValues());
        /*Despues convierte libros en un ContentValues y por último la inserta*/
    }

    /*Para consultar todos los datos de la tabla libros*/
    public Cursor getAllLibros() {
        return getReadableDatabase()
                .query(
                        LibrosEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getLibrosById(String librosId) {
        Cursor c = getReadableDatabase().query(
                LibrosEntry.TABLE_NAME,
                null,
                LibrosEntry.ID + " LIKE ?",
                new String[]{librosId},
                null,
                null,
                null);
        return c;
    }

    public int deleteLibros(String librosId) {
        return getWritableDatabase().delete(
                LibrosEntry.TABLE_NAME,
                LibrosEntry.ID + " LIKE ?",
                new String[]{librosId});
    }

    /*Le pasas  por parametro un objecto Libros y un String con el id a modificar*/
    public int updateLibros(Libros libros, String librosId) {
        /*Despues de convetirlo a content values llamas a updaate*/
        return getWritableDatabase().update(
                LibrosEntry.TABLE_NAME,
                libros.toContentValues(),/*Convierte a Content values*/
                LibrosEntry.ID + " LIKE ?",
                new String[]{librosId}
        );
    }
}