package com.example.anaguz.myapplication2;

import android.os.Bundle;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class pantalla2 extends AppCompatActivity{

@Override
    protected void onCreate(Bundle savedInstanceState) {


    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pantalla2);


    final TextView otroSaludo = (TextView) findViewById(R.id.saludo2);
    Bundle recogerBundle = getIntent().getExtras();

    showToast("Estoy en la pantalla 2");
    otroSaludo.setText(recogerBundle.getString("TEXTO"));
    showAlert("Alerta");

    }


    protected void showToast(CharSequence text){
        Context context=getApplicationContext();

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,text,duration);
        toast.show();


    }

    protected void showAlert( CharSequence text) {
        //CharSequence text = getResources().getString(R.string.noNameMsg);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(text);
        alert.setPositiveButton(android.R.string.ok, null);
        alert.show();
    }

}
