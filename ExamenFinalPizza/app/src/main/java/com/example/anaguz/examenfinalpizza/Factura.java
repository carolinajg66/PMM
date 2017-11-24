package com.example.anaguz.examenfinalpizza;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by anaguz on 17/11/17.
 */

public class Factura extends AppCompatActivity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_factura);


  // imagen = (ImageView)findViewById(R.id.imagen);
  TextView Nombre = (TextView) findViewById(R.id.pizza);
  TextView preciobase = (TextView) findViewById(R.id.precioBase);
  TextView envio = (TextView) findViewById(R.id.envio);
  TextView complmento1 = (TextView) findViewById(R.id.complemento1);
  TextView complemento2 = (TextView) findViewById(R.id.complemento2);
  TextView complemento3 = (TextView) findViewById(R.id.complemento3);
  TextView unidades = (TextView) findViewById(R.id.unidades);
  TextView total = (TextView) findViewById(R.id.total);
  Button atras = (Button) findViewById(R.id.atras);


  Bundle miBundle = getIntent().getExtras();
  pizza pizza = (pizza) miBundle.getSerializable("informacion");

  Nombre.setText(pizza.getNombre());
  //preciobase.setText(pizza.getPrecio());



 }
}