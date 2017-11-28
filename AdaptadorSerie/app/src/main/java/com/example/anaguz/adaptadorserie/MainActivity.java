package com.example.anaguz.adaptadorserie;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner miSpinner;
    private Series [] datos = new Series []{
        new Series("ShadowHunter","Ed Decter" ,2),
        new Series("The Vampire Diaries", "Kevin Williamson y Julie Plec",8),
        new Series ("The Originals", " Julie Plec",4)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miSpinner = (Spinner) findViewById(R.id.spPersona);
        AdaptadorSerie miAdaptador = new AdaptadorSerie(this);
        miSpinner.setAdapter(miAdaptador);


        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

               // String mensaje ="Nombre:"+ datos[i].getNombre() +" Apellidos: "+ datos[i].getApellidos();
               // Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();


               Series series= datos[i];

                Bundle miBundle = new Bundle();
                miBundle.putSerializable("CLAVEobjecto",series);

                Intent intent = new Intent(MainActivity.this,Pantalla2.class);
                intent.putExtras(miBundle);

                startActivity(intent);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

//    public void showToast(String text) {
//
//        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
//    }
    static class  ViewHolder{

        TextView Nombre;
        TextView Creador;
        TextView Temporadas;
        //ImageView foto;
    }

    class AdaptadorSerie extends ArrayAdapter<Series> {
        public Activity miActividad;

        public AdaptadorSerie(Activity laActividad) {
            super(laActividad, R.layout.itemadaptador, datos);
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
                item = inflater.inflate(R.layout.itemadaptador, null);


                holder = new ViewHolder();
                holder.Nombre = (TextView) item.findViewById(R.id.campoNombre);
                holder.Creador= (TextView) item.findViewById(R.id.campoCreador);
                holder.Temporadas = (TextView) item.findViewById(R.id.campoTemporadas);
               // holder.foto =(ImageView) item.findViewById(R.id.ivImagen);

                item.setTag(holder);

            } else {
                holder = (ViewHolder) item.getTag();
            }

            holder.Nombre.setText(datos[i].getNombre());
            holder.Creador.setText(datos[i].getCreador());
            holder.Temporadas.setText(String.valueOf(datos[i].getTemporadas()));
            //holder.foto.setBackground(getDrawable(datos[i].getImagen()));


            TextView IblNombre = (TextView) item.findViewById(R.id.campoNombre);
            IblNombre.setText(datos[i].getNombre());

            TextView IblCreador = (TextView) item.findViewById(R.id.campoCreador);
            IblCreador.setText(datos[i].getCreador());

            TextView IblTemporada = (TextView) item.findViewById(R.id.campoTemporadas);
            IblTemporada.setText(String.valueOf(datos[i].getTemporadas()));


            //ImageView imagen = (ImageView) item.findViewById(R.id.ivImagen);
            //imagen.setBackground(getDrawable(personas[i].getImagen()));

            return item;


        }

    }



    }

