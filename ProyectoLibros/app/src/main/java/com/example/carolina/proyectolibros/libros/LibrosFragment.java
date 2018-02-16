package com.example.carolina.proyectolibros.libros;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.carolina.proyectolibros.R;
import com.example.carolina.proyectolibros.addeditlibros.AddEditLibrosActivity;
import com.example.carolina.proyectolibros.datos.LibrosContract;
import com.example.carolina.proyectolibros.datos.LibrosSqlHelper;
import com.example.carolina.proyectolibros.librosdetail.LibrosDetailActivity;

public class LibrosFragment extends Fragment {

    public static final int REQUEST_UPDATE_DELETE_LIBROS = 2;

    private LibrosSqlHelper mLibrosSqlHelper;

    private ListView mLibrosList;
    private LibrosCursorAdapter mLibrosAdapter;
    private FloatingActionButton mAddButton;


    public LibrosFragment() {
        // Required empty public constructor
    }

    public static LibrosFragment newInstance() {
        return new LibrosFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_libros, container, false);

        // Referencias UI
        mLibrosList = (ListView) root.findViewById(R.id.lawyers_list);
        mLibrosAdapter = new LibrosCursorAdapter(getActivity(), null);
        mAddButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        // Setup
        mLibrosList.setAdapter(mLibrosAdapter);

        // Eventos
        mLibrosList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor currentItem = (Cursor) mLibrosAdapter.getItem(i);
                String currentLibrosId = currentItem.getString(
                        currentItem.getColumnIndex(LibrosContract.LibrosEntry.ID));

                showDetailScreen(currentLibrosId);
            }
        });

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddScreen();
            }
        });


        getActivity().deleteDatabase(LibrosSqlHelper.DATABASE_NAME);

        // Instancia de helper
        mLibrosSqlHelper = new LibrosSqlHelper(getActivity());

        // Carga de datos
        loadLibros();

        return root;
    }

/*Se procesa el resultado del codigo de perición para recargar la lista y mostrar
un mensahe de guardado exitoso, que es ShowSuccessFullsaveMessage*/


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Activity.RESULT_OK == resultCode) {
            switch (requestCode) {
                case AddEditLibrosActivity.REQUEST_ADD_LIBROS:
                    showSuccessfullSavedMessage();
                    loadLibros();
                    break;
                case REQUEST_UPDATE_DELETE_LIBROS:
                    loadLibros();
                    break;
            }
        }
    }

    private void loadLibros() {
        new LibrosLoadTask().execute();
    }

    /*El mensaje de guardado exitoso*/
    private void showSuccessfullSavedMessage() {
        Toast.makeText(getActivity(),
                "Libro guardado correctamente", Toast.LENGTH_SHORT).show();
    }
/*se inicia AddEditLawyerActivity y luego se llama dentro del controlador onClick()*/
    private void showAddScreen() {
        Intent intent = new Intent(getActivity(), AddEditLibrosActivity.class);
        startActivityForResult(intent, AddEditLibrosActivity.REQUEST_ADD_LIBROS);
    }


/*Se inicia la actividad con el id obtenido  en el metodo onItemclick*/
    private void showDetailScreen(String librosId) {
        Intent intent = new Intent(getActivity(), LibrosDetailActivity.class);
        intent.putExtra(LibrosActivity.EXTRA_LIBROS_ID, librosId);
        /*REQUEST_UPDATE_DELETE_LIBROS representa la vía de comunicación entre el
        screen de libros y la de detalles*/

        startActivityForResult(intent, REQUEST_UPDATE_DELETE_LIBROS);
    }


    private class LibrosLoadTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mLibrosSqlHelper.getAllLibros();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                mLibrosAdapter.swapCursor(cursor);
            } else {
                // Mostrar empty state
            }

        }

    }
}


