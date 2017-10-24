package com.example.anaguz.spinnermatrices;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.lista1);
        spinner.setOnItemSelectedListener(new SpinnerInfo());
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    private class SpinnerInfo implements AdapterView.OnItemSelectedListener {
//        @Override
//        public void onItemSelected(AdapterView<?> lista, View selectedView,
//                                int selectedIndex, long id) {
//            String selection = lista.getItemAtPosition(selectedIndex).toString();
//            showToast(selection);
//        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String selection = spinner.getItemAtPosition(i).toString();
           showToast(selection);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }

    public void onNothingSelected(AdapterView<?> lista) {
// Won’t be invoked unless you programmatically remove entries
    }
} //de la clase interna
