package com.example.anaguz.listatarea2;

import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public  class SimpleFragment extends Fragment {

    TextView mPlace =null;
    TextView mDescription =null;
    TextView mImportance =null;
    TextView mItem =null;
    TextView id;
    Integer mRowId = null;


    int mNum;
    static SimpleFragment newInstance(int number) {
        SimpleFragment f = new SimpleFragment();
        // Mantenemos el nÃºmero para usarlo en cualquier momento.
        Bundle args = new Bundle();
        args.putInt("num", number);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // obtenemos el nÃºmero que se habia pasado como argumento en
        // la creaciÃ³n de la instancia
        if (getArguments() != null) {
            mNum = getArguments().getInt("num");
        }
    }
   

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = null;
        View tv = null;
        // dependiendo de si es par o impar mostramos distintos layouts

        v = inflater.inflate(R.layout.frame_simple, container, false);
        tv = v.findViewById(R.id.text);


        ((TextView) tv).setText("Registro numero #" + mNum);

        //identificador visible o no
        TableRow tr = (TableRow)v.findViewById(R.id.idRow);
        // obtener referencias
         mItem = (TextView)v.findViewById(R.id.item);
         mPlace = (TextView)v.findViewById(R.id.place);
         mDescription = (TextView)v.findViewById(R.id.description);
         mImportance = (TextView)v.findViewById(R.id.importance);
         id = (TextView)v.findViewById(R.id.identificator1);
        populateFieldsFromDB(mNum);
        
       
        return v;


    }

    private void populateFieldsFromDB(int mNum) {
        try {
            MainActivity.mDbHelper.open();
            Cursor c = MainActivity.mDbHelper.getItem(mRowId.intValue());
            if (c.moveToFirst()) {
                //diferentes maneras de obtener los datos del cursor
                //Mediante nombre de columna y lanza excepción si no existe
                mItem.setText(c.getString(c.getColumnIndexOrThrow(DataBaseHelper.SL_ITEM)));
                //Mediante nombre de columna y devuelve -1 si no existe
                mPlace.setText(c.getString(c.getColumnIndex(DataBaseHelper.SL_PLACE)));
                //Mediante posición del campo en el cursor
                mDescription.setText(c.getString(2));
                mImportance.setText(Integer.toString(c.getInt(3)));
                //id = (TextView) findViewById(R.id.identificator1);
                id.setText(Integer.toString(c.getInt(4)));
            }
            c.close();
            MainActivity.mDbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
           // Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);

        }
    }


}




