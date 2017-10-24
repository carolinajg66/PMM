package com.example.anaguz.tiposeventos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MiButton extends Button implements View.OnClickListener {
    Context ctx=null;

    public MiButton(Context context) {
        super(context);
        ctx=context;
        this.setOnClickListener(this); //pedir recoger los eventos
    }


    //cuando se cree desde un recurso XML
    public MiButton(Context context, AttributeSet attr){
        super(context,attr);
        ctx=context;
        this.setOnClickListener(this);
    }

    //cuando se cree desde un recurso XML
    public MiButton(Context context, AttributeSet attr, int defaultStyles){

        super(context, attr, defaultStyles);
        ctx=context;
        this.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Toast.makeText(ctx, "Pulsado mi botón", Toast.LENGTH_SHORT).show();
    }

}