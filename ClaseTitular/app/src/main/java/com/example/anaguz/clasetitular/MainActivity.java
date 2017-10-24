package com.example.anaguz.clasetitular;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        private vampiros[] datos = new vampiros[]{
                new vampiros("Damon", "Salvatore", R.drawable.img1),
                new vampiros("Klaus", "Mikaelson",  R.drawable.img2),
                new vampiros("Kol", "Mikaelson", R.drawable.img3)

        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView ItsOpciones =(ListView)findViewById(R.id.LstOpciones);
        ItsOpciones.setAdapter(adaptador);

        ItsOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick (AdapterView arg0, View arg1, int position, long id){
                String mensaje ="Nombre:"+ datos[position].getNombre() +" Apellidos: "+ datos[position].getApellidos();
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }

        });

    }
static class  ViewHolder{

        TextView titulo;
        TextView subtitulo;
        ImageView foto;
    }


class AdaptadorTitulares extends ArrayAdapter {
    Activity context;

    AdaptadorTitulares(Activity context) {
        super(context, R.layout.listitem_titular, datos);
        this.context = context;
    }

    public View getView(int i, View convertView, ViewGroup parent) {

        ViewHolder holder;
        View item = convertView;

        if (item == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            item = inflater.inflate(R.layout.listitem_titular, null);

            holder = new ViewHolder();
            holder.titulo = (TextView) item.findViewById(R.id.tvTitulo);
            holder.subtitulo = (TextView) item.findViewById(R.id.tvSubtitulo);
            holder.foto =(ImageView) item.findViewById(R.id.ivImagen);

            item.setTag(holder);

        } else {
            holder = (ViewHolder) item.getTag();
        }

        holder.titulo.setText(datos[i].getNombre());
        holder.subtitulo.setText(datos[i].getApellidos());
        holder.foto.setBackground(getDrawable(datos[i].getImagen()));


        TextView IblTitulo = (TextView) item.findViewById(R.id.tvTitulo);
        IblTitulo.setText(datos[i].getNombre());

        TextView IblSubtitulo = (TextView) item.findViewById(R.id.tvSubtitulo);
        IblSubtitulo.setText(datos[i].getApellidos());

        ImageView imagen = (ImageView) item.findViewById(R.id.ivImagen);
        imagen.setBackground(getDrawable(datos[i].getImagen()));

        return (item);


    }

}
}

