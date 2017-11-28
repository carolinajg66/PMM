package com.example.anaguz.examencarolina;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    //Lista para el spinner
    private Pizza[] datos = new Pizza[]{
            new Pizza("Margarita ", "Jamon/Tomate", 12),
            new Pizza("Tres Quesos", "Queso 1/Queso 2", 15),
            new Pizza("Barbacoa", "Carne/Tomate", 15),
            new Pizza("Pepperoni ", "Queso/Pepperoni", 12),
    };

    private Object[] calculos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para rellenear el spinner
        AdaptadorDestino adaptador = new AdaptadorDestino(this);
        final Spinner zonas = (Spinner) findViewById(R.id.swpinner);
        zonas.setAdapter(adaptador);

        final RadioGroup tarifas = (RadioGroup)findViewById(R.id.tarifasnyu);
        final Button domicilio = (Button)findViewById(R.id.EnDomicilio);
        final Button local = (Button)findViewById(R.id.enLocal);
        final CheckBox extra = (CheckBox)findViewById(R.id.Extra);
        final CheckBox grande = (CheckBox)findViewById(R.id.Grande);
        final CheckBox extraQueso = (CheckBox)findViewById(R.id.ExtraQueso);
        final EditText NumeroUnidades = (EditText)findViewById(R.id.numeroUnidades);
        Button calcular = (Button)findViewById(R.id.hacerCalculos);

        //Obtener el precio y pasar pantalla
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Para empezar a pasar de pagina
                Intent paso = new Intent(MainActivity.this, Factura.class);

                //Para pasar objetos
                Bundle pasoobjetos = new Bundle();
                //Precio de la zona y pasar el objeto
                double preciozona = datos[zonas.getSelectedItemPosition()].getPrecio();
                Pizza destino = new Pizza (datos[zonas.getSelectedItemPosition()].getNombre(),
                        datos[zonas.getSelectedItemPosition()].getDescripcion(),
                        datos[zonas.getSelectedItemPosition()].getPrecio());


                pasoobjetos.putSerializable("destino", destino);
                paso.putExtras(pasoobjetos);

                //Precio del NumeroUnidades y pasarlo

                double preciopeso = 0;
                if (NumeroUnidades.getText().toString().isEmpty()){
                    NumeroUnidades.setText("0");
                }
                if (Double.parseDouble(NumeroUnidades.getText().toString()) < 6){
                    preciopeso = Double.parseDouble(NumeroUnidades.getText().toString()) * 1;
                }
                if (Double.parseDouble(NumeroUnidades.getText().toString()) >= 6 && Double.parseDouble(NumeroUnidades.getText().toString()) < 10){
                    preciopeso = Double.parseDouble(NumeroUnidades.getText().toString()) * 1.5;
                }
                if (Double.parseDouble(NumeroUnidades.getText().toString()) >= 10){
                    preciopeso = Double.parseDouble(NumeroUnidades.getText().toString()) * 2;
                }
                paso.putExtra("NumeroUnidades", NumeroUnidades.getText().toString());
                paso.putExtra("preciopeso", String.valueOf(preciopeso));
                double total =  preciozona + preciopeso;

                //Precio de tarifa y pasarlo
                double tarifa = 0;
                String ntarifa = " ";
                if (tarifas.getCheckedRadioButtonId() == R.id.enLocal){
                    ntarifa = domicilio.getText().toString();
                    tarifa = (total * 30 ) / 100;
                    ntarifa = domicilio.getText().toString();
                }
                if (tarifas.getCheckedRadioButtonId() == R.id.EnDomicilio){
                    ntarifa = local.getText().toString();
                    tarifa = 0;
                    ntarifa = local.getText().toString();
                }
                paso.putExtra("nombretarifa", ntarifa);
                paso.putExtra("tarifa", String.valueOf(tarifa));
                total = total + tarifa;
                paso.putExtra("total", String.valueOf(total));

                //Tipo de envoltorio
                boolean checked = false;
                if(grande.isChecked()){
                    checked = true;
                    paso.putExtra("cajaregalo", grande.getText().toString());
                    paso.putExtra("checked", checked);
                }
                if(extra.isChecked()){
                    checked = true;
                    paso.putExtra("extra", extra.getText().toString());
                    paso.putExtra("checked2", checked);
                }
                if(extraQueso.isChecked()){
                    checked = true;
                    paso.putExtra("extra queso ", extraQueso.getText().toString());
                    paso.putExtra("checked3", checked);
                }
                startActivity(paso);
                //String mensaje = "Total = " + total;
                //Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }
    //Menu de Arcerca DE y dibujar
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.acercaDe:
                Intent acercade = new Intent(MainActivity.this, acercade.class);
                startActivity(acercade);
                return true;
            case R.id.dibujar:
                Intent dibujo = new Intent(MainActivity.this, dibujar.class);
                startActivity(dibujo);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Rellenando el spinner
    public class AdaptadorDestino extends ArrayAdapter<Pizza> {
        Activity context;

        AdaptadorDestino(Activity context){
            super(context, R.layout.item_spinner, datos);
            this.context = context;
        }
        public  View getDropDownView (int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position, convertView, parent);
            return  vistaDesplegada;

        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.item_spinner, null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.campoZona);
            lblTitulo.setText(datos[i].getNombre());

            TextView lblSubtitulo = (TextView) item.findViewById(R.id.campoContinente);
            lblSubtitulo.setText(datos[i].getDescripcion());

            TextView lblPrecio = (TextView)item.findViewById(R.id.campoPrecio);
            lblPrecio.setText(String.valueOf(datos[i].getPrecio()) + "€");

            return (item);
        }

    }
}
