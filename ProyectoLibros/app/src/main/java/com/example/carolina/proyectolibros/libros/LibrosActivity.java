package com.example.carolina.proyectolibros.libros;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.carolina.proyectolibros.R;

public class LibrosActivity extends AppCompatActivity {

    public static final String EXTRA_LIBROS_ID = "extra_libros_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*Insertamos un fragmento --> Un fragmento tiene su propio ciclo de vida */
        LibrosFragment fragment = (LibrosFragment)
                getSupportFragmentManager().findFragmentById(R.id.libros_container);

        if (fragment == null) {
            fragment = LibrosFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.libros_container, fragment)
                    .commit();
        }

    }
}


