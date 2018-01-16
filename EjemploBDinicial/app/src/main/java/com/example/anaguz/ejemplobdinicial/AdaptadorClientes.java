package com.example.anaguz.ejemplobdinicial;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by anaguz on 16/01/18.
 */

public class AdaptadorClientes extends ArrayAdapter{
    Activity activity;
    Context context;
    ArrayList<Clientes> clientes;

    public AdaptadorClientes(Activity laActividad, ArrayList<Clientes> clientes) {
        super(laActividad, R.layout.itemspinner, clientes);
        this.activity= laActividad;
        this.clientes=clientes;
    }



    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View vistaDesplegada = getView(position, convertView, parent);
        return vistaDesplegada;
    }

    public View getView(int i, View convertView, ViewGroup parent) {

        ViewHolder holder;
        View item = convertView;

        if (item == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            item = inflater.inflate(R.layout.itemspinner, null);


            holder = new ViewHolder();
            holder.nombre = (TextView) item.findViewById(R.id.campoNombre);
            holder.telefono = (TextView) item.findViewById(R.id.campoTelefono);


            item.setTag(holder);

        } else {
            holder = (ViewHolder) item.getTag();
        }

        holder.nombre.setText(clientes.get(i).getNombre());
        holder.telefono.setText(clientes.get(i).getTelefono());



        TextView IblNombre = (TextView) item.findViewById(R.id.campoNombre);
        IblNombre.setText(clientes.get(i).getNombre());

        TextView IblTelefono = (TextView) item.findViewById(R.id.campoTelefono);
        IblTelefono.setText(clientes.get(i).getTelefono());


        return item;


    }
    class  ViewHolder{

        TextView nombre;
        TextView telefono;

    }
}
