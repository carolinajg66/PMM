package com.example.anaguz.adaptadorserie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.temporal.Temporal;

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);


        //TextView elsaludo=(TextView)findViewById(R.id.);


        Bundle miBundleRecoger= getIntent().getExtras();

        Series s= (Series) miBundleRecoger.getSerializable("CLAVEobjecto");
        //elsaludo.setText("Hola "+s.getNombre());

        TextView nombre= (TextView)findViewById(R.id.nombre);

        nombre.setText(s.getNombre());

        //Toast.makeText(this, "Nombre"+s.getNombre(), Toast.LENGTH_SHORT).show();

        TextView creador= (TextView) findViewById(R.id.Creador);

        creador.setText(s.getCreador());

        //Toast.makeText(this, "Creador;"+s.getCreador(), Toast.LENGTH_SHORT).show();

        TextView temporadas= (TextView) findViewById(R.id.Temporada);

        temporadas.setText(String.valueOf(s.getTemporadas()));

        //Toast.makeText(this, "Temporada;"+String.valueOf(s.getTemporadas()), Toast.LENGTH_SHORT).show();


       // ImageView imagen = (ImageView) findViewById(R.id.);

        //imagen.setBackground(getDrawable(v.getImagen()));



    }
}
