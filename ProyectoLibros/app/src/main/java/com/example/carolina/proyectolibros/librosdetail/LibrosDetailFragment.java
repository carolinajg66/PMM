package com.example.carolina.proyectolibros.librosdetail;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.carolina.proyectolibros.R;
import com.example.carolina.proyectolibros.addeditlibros.AddEditLibrosActivity;
import com.example.carolina.proyectolibros.datos.Libros;
import com.example.carolina.proyectolibros.datos.LibrosSqlHelper;
import com.example.carolina.proyectolibros.libros.LibrosActivity;
import com.example.carolina.proyectolibros.libros.LibrosFragment;
//import com.herprogramacion.lawyersapp.addeditlawyer.AddEditLawyerActivity;

    /**
     * Vista para el detalle del libros
     */
    public class LibrosDetailFragment extends Fragment {
        private static final String ARG_LIBROS_ID = "librosId";

        private String mLibrosId;

        private CollapsingToolbarLayout mCollapsingView;
        private ImageView mPortada;
        private TextView mGenero;
        private TextView mAutor;
        private TextView mIsbn;
        private TextView mSipnosis;
        private TextView mPrestado;


        private LibrosSqlHelper mLibrosSqlHelper;


        public LibrosDetailFragment() {
            // Required empty public constructor
        }

        public static LibrosDetailFragment newInstance(String librosId) {
            LibrosDetailFragment fragment = new LibrosDetailFragment();
            Bundle args = new Bundle();
            args.putString(ARG_LIBROS_ID, librosId);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if (getArguments() != null) {
                mLibrosId = getArguments().getString(ARG_LIBROS_ID);
            }

            setHasOptionsMenu(true);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.fragment_libros_detail, container, false);
            mCollapsingView = (CollapsingToolbarLayout) getActivity().findViewById(R.id.toolbar_layout);
            mPortada = (ImageView) getActivity().findViewById(R.id.iv_image);
            mGenero = (TextView) root.findViewById(R.id.tv_genero);
            mAutor = (TextView) root.findViewById(R.id.tv_autor);
            mIsbn = (TextView) root.findViewById(R.id.tv_isbn);
            mSipnosis = (TextView) root.findViewById(R.id.tv_sipnosis);
            mPrestado = (TextView) root.findViewById(R.id.tv_prestado);


            mLibrosSqlHelper = new LibrosSqlHelper(getActivity());

            loadLibros();

            return root;
        }

        private void loadLibros() {
            new GetLibrosByIdTask().execute();
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                /*Procesa los casos de edicion y eliminación*/
                case R.id.action_edit:
                    showEditScreen();
                    break;
                case R.id.action_delete:
                    new DeleteLibrosTask().execute();
                    break;
            }
            return super.onOptionsItemSelected(item);
        }

       /*Sirve para reportarle a LibrosFragment la necesidad de actualzar la lista
       cuando se produscan camnbios al eliminar o editar
        */
        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == LibrosFragment.REQUEST_UPDATE_DELETE_LIBROS) {
                if (resultCode == Activity.RESULT_OK) {
                    getActivity().setResult(Activity.RESULT_OK);
                    getActivity().finish();
                }
            }
        }

        private void showLibros(Libros libros) {
            mCollapsingView.setTitle(libros.getTitulo());
            Glide.with(this)
                    .load(Uri.parse("file:///android_asset/" + libros.getPortada()))
                    .centerCrop()
                    .into(mPortada);
            mGenero.setText(libros.getGenero());
            mAutor.setText(libros.getAutor());
            mIsbn.setText(libros.getIsbn());
            mSipnosis.setText(libros.getSipnosis());
            mPrestado.setText(libros.getPrestado());
        }

        private void showEditScreen() {
            Intent intent = new Intent(getActivity(), AddEditLibrosActivity.class);
            intent.putExtra(LibrosActivity.EXTRA_LIBROS_ID, mLibrosId);
            startActivityForResult(intent, LibrosFragment.REQUEST_UPDATE_DELETE_LIBROS);
        }
        /*Cierra la acrividad de detalle con un resultado favorable si la eliminación a
        se ha llevado a cabo , sino muestra un error
         */
        private void showLibrossScreen(boolean requery) {
            if (!requery) {
                showDeleteError();/*Llamas al mensaje que saldra si hay algun error*/
            }
            getActivity().setResult(requery ? Activity.RESULT_OK : Activity.RESULT_CANCELED);
            getActivity().finish();
        }/home/anaguz/Descargas/ProyectoLibros

        /*Error por si no se lleva a cabo favorablemente la eliminacion */

        private void showLoadError() {
            Toast.makeText(getActivity(),
                    "Error al cargar información de libro", Toast.LENGTH_SHORT).show();
        }

        private void showDeleteError() {
            Toast.makeText(getActivity(),
                    "Error al eliminar libro", Toast.LENGTH_SHORT).show();
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
                }
            }

        }


        private class DeleteLibrosTask extends AsyncTask<Void, Void, Integer> {

            @Override
            protected Integer doInBackground(Void... voids) {
                return mLibrosSqlHelper.deleteLibros(mLibrosId);
            }

            @Override
            protected void onPostExecute(Integer integer) {
                /*Llamas al showLibrosScreen*/
                showLibrossScreen(integer > 0);
            }

        }

    }
