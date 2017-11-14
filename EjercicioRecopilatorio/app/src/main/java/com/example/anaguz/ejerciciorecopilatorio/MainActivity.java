package com.example.anaguz.ejerciciorecopilatorio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner miSpinner;
    final static String zona[] = {"Zona A Asia y Oceanía 30€", "Zona B América y África 20€", "Zona C Europa 10€"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mensaje;
        miSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, zona);

        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
