package com.example.anaguz.listatarea2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by anaguz on 15/12/17.
 */

public class EjemploPreferencias extends AppCompatActivity {

    private Button btnPreferencias;
    private android.widget.Button btnObtenPreferencias;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_opciones);

        btnPreferencias = (Button)findViewById(R.id.BtnPreferencias);
        btnObtenPreferencias = (Button)findViewById(R.id.new_item1);
        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EjemploPreferencias.this,PantallaOpciones.class));
            }
        });
        btnObtenPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(EjemploPreferencias.this);
                String preferen1 = "desactivada";
                if(pref.getBoolean("opcion1", false)) preferen1="activada";
                Toast.makeText(getApplicationContext(), preferen1,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), pref.getString("opcion2",""),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), pref.getString("opcion3",""),Toast.LENGTH_SHORT).show();
            }
        });


    }
}

