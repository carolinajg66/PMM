package com.example.anaguz.clasetitular;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        TextView elsaludo=(TextView)findViewById(R.id.saludo);


        Bundle miBundleRecoger= getIntent().getExtras();

        vampiros v= (vampiros) miBundleRecoger.getSerializable("CLAVEobjecto");
         elsaludo.setText("Hola "+v.getNombre());

        TextView nombre= (TextView)findViewById(R.id.nombrePantalla2);

        nombre.setText(v.getNombre());

        TextView apellido= (TextView) findViewById(R.id.apellidoPantalla2);

        apellido.setText(v.getApellidos());

        ImageView imagen = (ImageView) findViewById(R.id.imagenPantalla2);

        imagen.setBackground(getDrawable(v.getImagen()));
    }
}
