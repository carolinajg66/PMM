package com.example.anaguz.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto= (EditText)findViewById(R.id.miTxt);
        final Button miBoton= (Button)findViewById(R.id.miBtn);
        final TextView elSaludo= (TextView)findViewById(R.id.miLbl);

        miTexto.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){

                miTexto.setText(" ");
            }
        }
        );//evento

        miBoton.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){


                Intent miIntent= new Intent(MainActivity.this, pantalla2.class);

                Bundle miBundle=new Bundle();
                String mensajePaso= "Te saludo " + miTexto.getText();
                //showToast("Estoy en la pantalla 1");

                miBundle.putString("TEXTO",mensajePaso);
                miIntent.putExtras(miBundle);

                startActivity(miIntent);

                //showAlert("Alerta1");
            }
        }
        );//evento




    }//OnCreate

  /*  protected void showToast(CharSequence text){
        Context context=getApplicationContext();

        int duration =Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,text,duration);
        toast.show();

        //Toast.makeText(this, "TEXTO",Toast.LENGTH_SHORT).show();
    }

    protected void showAlert( CharSequence text) {
        //CharSequence text = getResources().getString(R.string.noNameMsg);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(text);
        alert.setPositiveButton(android.R.string.ok, null);
        alert.show();
    }*/
}
