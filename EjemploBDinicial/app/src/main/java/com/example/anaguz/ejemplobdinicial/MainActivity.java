package com.example.anaguz.ejemplobdinicial;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {
    ArrayList<Clientes> datos;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datos = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listaClientes);
        //Abrimos la base de datos en modo escritura
        final ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBClientes", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        SQLiteDatabase bd = cliBDh.getWritableDatabase();

        //En caso de abrir de forma correcta la base de datos
        if (bd != null) {
            //Introducimos 3 clientes de ejemplo
            for (int cont = 1; cont <= 3; cont++) {
                //Creamos los datos
                int codigo = cont;
                String nombre = "Cliente" + cont;
                String telefono = cont + "XXXXXXX";

                //Introducimos los datos en la tabla Clientes
                bd.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
                        "VALUES (" + codigo + ", '" + nombre + "', '" + telefono + "')");
            }

            //Insertar un registro
            bd.execSQL("INSERT INTO Clientes (nombre, telefono) VALUES ('cli1','11111') ");
            //Actualizar un registro
            bd.execSQL("UPDATE Clientes SET telefono='00000' WHERE nombre='cli1' ");
            //Eliminar un registro
            bd.execSQL("DELETE FROM Clientes WHERE nombre='cli1' ");

            //Ejemplo de utilización del método insert()
            //Creamos el registro que queremos insertar utilizando un objeto ContentValues
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("nombre", "cli10");
            nuevoRegistro.put("telefono", "101010");
            //Insertamos el registro en la base de datos
            //El primer parámetro es el nombre de la tabla donde insertaremos.
            //El segundo parámetro solo sirve en caso de introducir un registro vacio
            //El tercer paráemtro es el objeto ContentValues que contiene el registro a insertar
            bd.insert("Clientes", null, nuevoRegistro);

            //Ejemplo de utilización del método update()
            //Establecemos los campos-valores que vamos a actualizar
            ContentValues valores = new ContentValues();
            valores.put("telefono", "101010XX");
            //Actualizamos el registro en la base de datos
            //El tercer argumento es la condición del UPDATE tal como lo haríamos en la cláusula
            //WHERE en una sentencia SQL normal.
            //El cuarto argumento son partes variables de la sentencia SQL que aportamos en un
            //vector de valores aparte
            String[] args = new String[]{"cli1", "cli2"};
            bd.update("Clientes", valores, "nombre=? OR nombre=?", args);

            //Ejemplo de utilización del método delete()
            //Eliminamos el registro del cliente 'cli2'
            String[] args2 = new String[]{"cli2"};
            bd.delete("Clientes", "nombre=?", args2);

            //Ejemplo Select
            String[] args3 = new String[]{"cli1"};
            Cursor c = bd.rawQuery("SELECT nombre,telefono FROM Clientes WHERE nombre=? ", args3);
            listView.setAdapter(new AdaptadorClientes(this, datos));
            //Ejemplo Select2
            String[] campos = new String[]{"nombre", "telefono"};
            String[] args4 = new String[]{"cli1"};
            c = bd.rawQuery("SELECT * FROM Clientes",null);
            //Nos aseguramos de que exista al menos un registro
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    String nombreCli = c.getString(0);
                    String telefonoCli = c.getString(1);
                    Clientes cliente = new Clientes(nombreCli, telefonoCli);
                    datos.add(cliente);
                } while (c.moveToNext());
            }



            //Cerramos la base de datos
            bd.close();
        }

        //del if

//		class  ViewHolder{
//
//			TextView nombre;
//			TextView telefono;
//
//		}
//		class AdaptadorClientes extends ArrayAdapter<Clientes> {
//			Activity activity;
//			Context context;
//			Clientes[] clientes;
//
//			public AdaptadorClientes(Activity laActividad, Clientes[] clientes) {
//				super(laActividad, R.layout.itemspinner, clientes);
//				this.activity= laActividad;
//				this.clientes=clientes;
//			}
//
//
//
//			public View getDropDownView(int position, View convertView, ViewGroup parent) {
//				View vistaDesplegada = getView(position, convertView, parent);
//				return vistaDesplegada;
//			}
//
//			public View getView(int i, View convertView, ViewGroup parent) {
//
//				ViewHolder holder;
//				View item = convertView;
//
//				if (item == null) {
//					LayoutInflater inflater = activity.getLayoutInflater();
//					item = inflater.inflate(R.layout.itemspinner, null);
//
//
//					holder = new ViewHolder();
//					holder.nombre = (TextView) item.findViewById(R.id.campoNombre);
//					holder.telefono = (TextView) item.findViewById(R.id.campoTelefono);
//
//
//					item.setTag(holder);
//
//				} else {
//					holder = (ViewHolder) item.getTag();
//				}
//
//				holder.nombre.setText(clientes[i].getNombre());
//				holder.telefono.setText(clientes[i].getTelefono());
//
//
//
//				TextView IblNombre = (TextView) item.findViewById(R.id.campoNombre);
//				IblNombre.setText(clientes[i].getNombre());
//
//				TextView IblTelefono = (TextView) item.findViewById(R.id.campoTelefono);
//				IblTelefono.setText(clientes[i].getTelefono());
//
//
//				return item;
//
//
//			}
//
//		}

    }

}

