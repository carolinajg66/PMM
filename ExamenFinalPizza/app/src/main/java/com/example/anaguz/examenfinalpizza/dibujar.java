package com.example.anaguz.examenfinalpizza;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by anaguz on 17/11/17.
 */

public class dibujar {

    public class Dibujo extends View {
        public Dibujo(Context context) {
            super(context);
        }


        protected void onDraw(Canvas canvas) {

            Paint triangulo = new Paint();
            Paint circulo=new Paint();
            Paint cuerpo=new Paint();
            Paint brazos= new Paint();
            Paint piernas= new Paint();
            Paint ojos= new Paint();
            Paint boca= new Paint();

            triangulo.setColor(Color.BLACK);
            triangulo.setStrokeWidth(15);
            triangulo.setStyle(Paint.Style.STROKE);


            canvas.drawLine(500,60,200,300,triangulo);

            canvas.drawLine(900,300,500,60,triangulo);

            canvas.drawLine(200,300,900,300,triangulo);

           // circulo.setColor(Color.BLACK);
           // circulo.setStrokeWidth(15);
           // circulo.setStyle(Paint.Style.STROKE);

            canvas.drawCircle(550,450,150,circulo);

            cuerpo.setColor(Color.BLACK);
            cuerpo.setStrokeWidth(15);
            cuerpo.setStyle(Paint.Style.STROKE);


            canvas.drawLine(450,600,650,600,cuerpo);

            canvas.drawLine(400,900,450,600,cuerpo);

            canvas.drawLine(700,900,650,600,cuerpo);

            canvas.drawLine(400,900,700,900,cuerpo);

            brazos.setColor(Color.BLACK);
            brazos.setStrokeWidth(15);
            brazos.setStyle(Paint.Style.STROKE);


            canvas.drawLine(150,850,450,650,brazos);

            canvas.drawLine(950,850,650,650,brazos);

            piernas.setColor(Color.BLACK);
            piernas.setStrokeWidth(15);
            piernas.setStyle(Paint.Style.STROKE);


            canvas.drawLine(525,900,525,1200,piernas);

            canvas.drawLine(575,900,575,1200,piernas);

            ojos.setColor(Color.BLACK);
            ojos.setStrokeWidth(15);
            ojos.setStyle(Paint.Style.STROKE);


            canvas.drawCircle(500,400,20,ojos);

            canvas.drawCircle(600,400,20,ojos);

            boca.setColor(Color.BLACK);
            boca.setStrokeWidth(15);
            boca.setStyle(Paint.Style.STROKE);


        }
    }
}
