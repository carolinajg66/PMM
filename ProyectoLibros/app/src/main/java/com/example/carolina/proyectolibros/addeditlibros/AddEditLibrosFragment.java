package com.example.carolina.proyectolibros.addeditlibros;


import android.app.Activity;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carolina.proyectolibros.R;
import com.example.carolina.proyectolibros.datos.Libros;
import com.example.carolina.proyectolibros.datos.LibrosSqlHelper;


public class AddEditLibrosFragment extends Fragment {
    private static final String ARG_LIBROS_ID = "arg_libros_id";

    private String mLibrosId;

    private LibrosSqlHelper mLibrosSqlHelper;

    private FloatingActionButton mSaveButton;

    private TextInputEditText mTituloField;
    private TextInputEditText mGeneroField;
    private TextInputEditText mAutorField;
    private TextInputEditText mIsbnField;
    private TextInputEditText mSipnosisField;
    private TextInputEditText mPrestadoField;

    private TextInputLayout mTituloLabel;
    private TextInputLayout mGeneroLabel;
    private TextInputLayout mAutorLabel;
    private TextInputLayout mIsbnLabel;
    private TextInputLayout mSipnosisLabel;
    private TextInputLayout mPrestadoLabel;


    public AddEditLibrosFragment() {
        // Required empty public constructor
    }

    public static AddEditLibrosFragment newInstance(String librosid) {
        AddEditLibrosFragment fragment = new AddEditLibrosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_LIBROS_ID, librosid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mLibrosId = getArguments().getString(ARG_LIBROS_ID);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add_edit_libros, container, false);

        // Referencias UI
        mSaveButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        mTituloField = (TextInputEditText) root.findViewById(R.id.et_titulo);
        mGeneroField = (TextInputEditText) root.findViewById(R.id.et_genero);
        mAutorField = (TextInputEditText) root.findViewById(R.id.et_autor);
        mIsbnField = (TextInputEditText) root.findViewById(R.id.et_isbn);
        mSipnosisField = (TextInputEditText) root.findViewById(R.id.et_sipnosis);
        mPrestadoField = (TextInputEditText) root.findViewById(R.id.et_prestado);
        mTituloLabel = (TextInputLayout) root.findViewById(R.id.til_titulo);
        mGeneroLabel = (TextInputLayout) root.findViewById(R.id.til_genero);
        mAutorLabel = (TextInputLayout) root.findViewById(R.id.til_autor);
        mIsbnLabel = (TextInputLayout) root.findViewById(R.id.til_isbn);
        mSipnosisLabel = (TextInputLayout) root.findViewById(R.id.til_sipnosis);
        mPrestadoLabel = (TextInputLayout) root.findViewById(R.id.til_prestado);

        // Eventos
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEditLibros();
            }
        });

        mLibrosSqlHelper = new LibrosSqlHelper(getActivity());

        // Carga de datos
        if (mLibrosId != null) {
            loadLibros();
        }

        return root;
    }

    private void loadLibros() {
        new GetLibrosByIdTask().execute();
    }

    /*Esta metodo comprueba que los campos de texto no esten vacios y
     luego crea una nueva instancia Lawyer con ellos*/
    private void addEditLibros() {
        boolean error = false;

        String titulo = mTituloField.getText().toString();
        String genero = mGeneroField.getText().toString();
        String autor = mAutorField.getText().toString();
        String isbn = mIsbnField.getText().toString();
        String sipnosis= mSipnosisField.getText().toString();
        String prestado = mPrestadoField.getText().toString();

        if (TextUtils.isEmpty(titulo)) {
            mTituloLabel.setError("Ingresa un valor");
            error = true;
        }

        if (TextUtils.isEmpty(genero)) {
            mGeneroLabel.setError("Ingresa un valor");
            error = true;
        }

        if (TextUtils.isEmpty(autor)) {
            mAutorLabel.setError("Ingresa un valor");
            error = true;
        }


        if (TextUtils.isEmpty(isbn)) {
            mIsbnLabel.setError("Ingresa un valor");
            error = true;
        }
        if (TextUtils.isEmpty(sipnosis)) {
            mSipnosisLabel.setError("Ingresa un valor");
            error = true;
        }

        if (TextUtils.isEmpty(prestado)) {
            mPrestadoLabel.setError("Ingresa un valor");
            error = true;
        }


        if (error) {
            return;
        }

        Libros libros = new Libros(titulo,genero,autor,isbn,sipnosis,prestado,"");

        new AddEditLibrosTask().execute(libros);

    }
    /*Muestra la actividad de libros, se llama en el onPostExecute()*/

    private void showLibrosScreen(Boolean requery) {
        if (!requery) {
            showAddEditError();
            getActivity().setResult(Activity.RESULT_CANCELED);
        } else {
            getActivity().setResult(Activity.RESULT_OK);
        }

        getActivity().finish();
    }

    private void showAddEditError() {
        Toast.makeText(getActivity(),
                "Error al agregar nueva información", Toast.LENGTH_SHORT).show();
    }

    private void showLibros(Libros libros) {
        mTituloField.setText(libros.getTitulo());
        mGeneroField.setText(libros.getGenero());
        mAutorField.setText(libros.getAutor());
        mIsbnField.setText(libros.getIsbn());
        mSipnosisField.setText(libros.getSipnosis());
        mPrestadoField.setText(libros.getPrestado());
    }

    private void showLoadError() {
        Toast.makeText(getActivity(),
                "Error al editar libro", Toast.LENGTH_SHORT).show();
    }

    private class GetLibrosByIdTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mLibrosSqlHelper.getLibrosById(mLibrosId);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.moveToLast()) {
                showLibros(new Libros(cursor));
            } else {
                showLoadError();
                getActivity().setResult(Activity.RESULT_CANCELED);
                getActivity().finish();
            }
        }

    }

/*Comprueba en doInBackground el contenido de mLibrosId, si este no es null, entonces realia
una actualización, de lo contrario una inserción
 */
    private class AddEditLibrosTask extends AsyncTask<Libros, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Libros... libros) {
            if (mLibrosId != null) {
                return mLibrosSqlHelper.updateLibros(libros[0],mLibrosId)>0;
            } else {
                return mLibrosSqlHelper.saveLibros(libros[0])> 0;
            }

        }

        @Override
        protected void onPostExecute(Boolean result) {
            showLibrosScreen(result);
        }


    }

}
