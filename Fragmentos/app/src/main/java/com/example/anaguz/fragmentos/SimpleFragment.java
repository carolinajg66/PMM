package com.example.anaguz.fragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


    public  class SimpleFragment extends Fragment {
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
            mNum = getArguments().getInt("num");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v  = null;
            View tv  = null;
            // dependiendo de si es par o impar mostramos distintos layouts
            if (mNum % 2 == 0){
                v = inflater.inflate(R.layout.frame_simple, container, false);
                tv = v.findViewById(R.id.text);

            }
            else{
                v = inflater.inflate(R.layout.frame_simple2 , container, false);
                tv = v.findViewById(R.id.text2);


            }

            ((TextView)tv).setText("Fragmento numero #" + mNum);
            return v;
        }
    }



