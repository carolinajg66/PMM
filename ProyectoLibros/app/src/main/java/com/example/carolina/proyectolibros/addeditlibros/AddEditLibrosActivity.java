package com.example.carolina.proyectolibros.addeditlibros;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.carolina.proyectolibros.R;
import com.example.carolina.proyectolibros.libros.LibrosActivity;

public class AddEditLibrosActivity extends AppCompatActivity {
    public static final int REQUEST_ADD_LIBROS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_libros);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String libroId = getIntent().getStringExtra(LibrosActivity.EXTRA_LIBROS_ID);

        setTitle(libroId == null ? "Añadir libro" : "Editar libro");

        AddEditLibrosFragment addEditLibrosFragment = (AddEditLibrosFragment)
                getSupportFragmentManager().findFragmentById(R.id.add_edit_libros_container);
        if (addEditLibrosFragment == null) {
            addEditLibrosFragment = AddEditLibrosFragment.newInstance(libroId);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.add_edit_libros_container, addEditLibrosFragment)
                    .commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
