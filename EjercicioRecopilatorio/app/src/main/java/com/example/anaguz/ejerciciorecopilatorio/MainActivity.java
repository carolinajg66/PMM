package com.example.anaguz.ejerciciorecopilatorio;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Spinner miSpinner;

    public Destino[] zona = new Destino[]{
            new Destino("Zona A", "Asia y Oceanía", 30 ),
            new Destino("Zona A", "América y África", 20 ),
            new Destino("Zona A", "Europa", 10 )

    };
    //final static String zona[] = {"Zona A Asia y Oceanía 30€", "Zona B América y África 20€", "Zona C Europa 10€"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mensaje;
        miSpinner = (Spinner) findViewById(R.id.spinner);


        miSpinner = (Spinner) findViewById(R.id.spinner);
        AdaptadorDestino miAdaptador = new AdaptadorDestino(this);
        //miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        miSpinner.setAdapter(miAdaptador);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /*evento distinto al ListView */
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "";
                mensaje = "Item clicked => " + zona[position];
                showToast(mensaje);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }//del OnCreate

    static class ViewHolder{
        TextView zona;
        TextView continente;
        TextView precio;
    }

    class AdaptadorDestino extends ArrayAdapter<Destino> {
        public Activity miActividad;

        public AdaptadorDestino(Activity laActividad) {
            super(laActividad, R.layout.item_spinner, zona);
            this.miActividad = laActividad;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent) {

            ViewHolder holder;
            View item = convertView;

            if (item == null) {
                LayoutInflater inflater = miActividad.getLayoutInflater();
                item = inflater.inflate(R.layout.item_spinner, null);


                holder = new ViewHolder();
                holder.zona = (TextView) item.findViewById(R.id.campoZona);
                holder.continente = (TextView) item.findViewById(R.id.campoContinente);
                holder.precio = (TextView) item.findViewById(R.id.campoPrecio);


                item.setTag(holder);

            } else {
                holder = (ViewHolder) item.getTag();
            }

            holder.zona.setText(zona[i].getZona());
            holder.continente.setText(zona[i].getContinente());
            holder.precio.setText(String.valueOf(zona[i].getPrecio()));


            TextView IblZona = (TextView) item.findViewById(R.id.campoZona);
            IblZona.setText(zona[i].getZona());

            TextView IblContinente = (TextView) item.findViewById(R.id.campoContinente);
            IblContinente.setText(zona[i].getContinente());

            TextView IblPrecio = (TextView) item.findViewById(R.id.campoPrecio);
            IblPrecio.setText(String.valueOf(zona[i].getPrecio()));



            return item;


        }

    }
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
