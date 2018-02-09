package com.example.anaguz.preferencias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by anaguz on 15/12/17.
 */

public class EjemploPreferencias extends AppCompatActivity {

    private Button btnPreferencias;
    private Button btnObtenerPreferencias;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPreferencias = (Button)findViewById(R.id.BtnPreferencias);
        btnObtenerPreferencias=(Button)findViewById(R.id.BtnObtenerPreferencias);

        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EjemploPreferencias.this,PantallaOpciones.class));
            }
        });

        btnObtenerPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(
                        EjemploPreferencias.this);

                String preferen1="desactivada";
                if (pref.getBoolean("opcion1",false)) preferen1="Activada";
                Toast.makeText(getApplicationContext(), preferen1,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), pref.getString("opcion2",""),Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), pref.getString("opcion3",""),Toast.LENGTH_LONG).show();
            }
        });
    }

    //recogerPreferencias

    }