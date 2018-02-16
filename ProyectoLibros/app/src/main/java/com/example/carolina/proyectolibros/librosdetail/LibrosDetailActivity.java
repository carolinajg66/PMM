package com.example.carolina.proyectolibros.librosdetail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.carolina.proyectolibros.R;
import com.example.carolina.proyectolibros.libros.LibrosActivity;
import com.example.carolina.proyectolibros.librosdetail.LibrosDetailFragment;

/*Es un Scrolling Activity*/
public class LibrosDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String id = getIntent().getStringExtra(LibrosActivity.EXTRA_LIBROS_ID);

        LibrosDetailFragment fragment = (LibrosDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.libros_detail_container);
        if (fragment == null) {
            fragment = LibrosDetailFragment.newInstance(id);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.libros_detail_container, fragment)
                    .commit();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_libros_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
