package com.example.anaguz.transiciones;

import android.graphics.drawable.TransitionDrawable;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
TransitionDrawable  miTransicion;
    ImageView imagen1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen1 =(ImageView)findViewById(R.id.img1);
        miTransicion=(TransitionDrawable)getResources().getDrawable(R.drawable.transition);


        imagen1.setImageDrawable(miTransicion);

    }

    public boolean onTouchEvent(MotionEvent evento){

        if (evento.getAction()== MotionEvent.ACTION_DOWN){

            miTransicion.startTransition(1000);
            return true;
        }
        return super.onTouchEvent(evento);
    }
}
