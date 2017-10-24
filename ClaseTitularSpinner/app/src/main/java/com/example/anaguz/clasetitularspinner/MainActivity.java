package com.example.anaguz.clasetitularspinner;

import android.app.Activity;
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

    public Spinner miSpinner;
    public vampiros[] personas = new vampiros[]{
            new vampiros("Damon", "Salvatore", 20, R.drawable.img1),
            new vampiros("Klaus", "Mikaelson", 21, R.drawable.img2),
            new vampiros("Kol", "Mikaelson", 22, R.drawable.img3)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miSpinner = (Spinner) findViewById(R.id.spPersona);
        AdaptadorPersona miAdaptador = new AdaptadorPersona(this);
        miSpinner.setAdapter(miAdaptador);


        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String mensaje=" ";
                mensaje="Item clicked => "+personas[i];
                showToast(mensaje);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    static class  ViewHolder{

        TextView titulo;
        TextView subtitulo;
        TextView edad;
        ImageView foto;
    }


    public void showToast(String text) {

        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    class AdaptadorPersona extends ArrayAdapter<vampiros> {
        public Activity miActividad;

        public AdaptadorPersona(Activity laActividad) {
            super(laActividad, R.layout.itemspinner, personas);
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
                item = inflater.inflate(R.layout.itemspinner, null);


                holder = new ViewHolder();
                holder.titulo = (TextView) item.findViewById(R.id.campoNombre);
                holder.subtitulo = (TextView) item.findViewById(R.id.campoApellido);
                holder.edad = (TextView) item.findViewById(R.id.campoEdad);
                holder.foto =(ImageView) item.findViewById(R.id.ivImagen);

                item.setTag(holder);

            } else {
                holder = (ViewHolder) item.getTag();
            }

            holder.titulo.setText(personas[i].getNombre());
            holder.subtitulo.setText(personas[i].getApellidos());
            holder.foto.setBackground(getDrawable(personas[i].getImagen()));


            TextView IblNombre = (TextView) item.findViewById(R.id.campoNombre);
            IblNombre.setText(personas[i].getNombre());

            TextView IblApellido = (TextView) item.findViewById(R.id.campoApellido);
            IblApellido.setText(personas[i].getApellidos());

            TextView IblEdad = (TextView) item.findViewById(R.id.campoEdad);
            IblEdad.setText(String.valueOf(personas[i].getEdad()));


            ImageView imagen = (ImageView) item.findViewById(R.id.ivImagen);
            imagen.setBackground(getDrawable(personas[i].getImagen()));

            return item;


        }

    }
}

