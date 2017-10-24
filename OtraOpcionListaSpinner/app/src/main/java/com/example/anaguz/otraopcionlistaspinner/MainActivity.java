package com.example.anaguz.otraopcionlistaspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lview;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lview = (ListView) findViewById(R.id.lista1);
        lview.setOnItemClickListener(new ListaInfo());

    }
    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    private class ListaInfo implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> lista, View selectedView,
                                int selectedIndex, long id) {
            String selection =
                    lista.getItemAtPosition(selectedIndex).toString();
            showToast(selection);
        }

        public void onNothingSelected(AdapterView<?> lista) {
            // Cuando NO HAY entradas en la lista
        }
    } //clase interna
} //clase general



