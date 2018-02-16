package com.example.carolina.proyectolibros.libros;


import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import com.example.carolina.proyectolibros.R;
import com.example.carolina.proyectolibros.datos.LibrosContract.LibrosEntry;

/**
 * Adaptador de abogados
 */

public class LibrosCursorAdapter extends CursorAdapter {

    /*Construtor que transmite los parametros a a traves de super
    para mantener la herencia
     */
    public LibrosCursorAdapter(Context context, Cursor c)
    {
        super(context, c, 0);
    }

    /*En este metodo accedemos a la instancia LayoutInflater
    a traves de context
     */

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
       /*Invocamos inflate para inflar el layout del item*/
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.list_item_libros, viewGroup, false);
    }

    /*Implementamos este metodo para obtener el valos de las columnas
    name y avatarUri
     */
    @Override
    public void bindView(View view, final Context context, Cursor cursor) {

        // Referencias UI.
        TextView nameText = (TextView) view.findViewById(R.id.tv_name);
        final ImageView avatarImage = (ImageView) view.findViewById(R.id.iv_image);

        // Get valores.
        String name = cursor.getString(cursor.getColumnIndex(LibrosEntry.TITULO));
        String avatarUri = cursor.getString(cursor.getColumnIndex(LibrosEntry.PORTADA));

        // Setup.
        nameText.setText(name);

        /*Para utilizar Glide, primero se necesita importar una libreria en build.gradle
        * Esta libreria sirve para descargar y mostrar imagenes, tambiem permite reproducir gifs*/

        /*Carga una imagen desde la carpeta assets en forma de Bitmap sobre el view avatarImage*/
        Glide
                .with(context)
                .load(Uri.parse("file:///android_asset/" + avatarUri))
                .asBitmap()
                .error(R.drawable.ic_account_circle)
                .centerCrop()
                .into(new BitmapImageViewTarget(avatarImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable drawable
                                = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        drawable.setCircular(true);
                        avatarImage.setImageDrawable(drawable);
                    }
                });

    }

}
