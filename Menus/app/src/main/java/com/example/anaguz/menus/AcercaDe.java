package com.example.anaguz.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

public class AcercaDe extends AppCompatActivity {

    private TextView lblMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        /*//Obtenemos las referencias a los controles
        lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        //Asociamos los menús contextuales a los controles
        registerForContextMenu(lblMensaje);*/
    }


}
