package com.example.anaguz.preferencias;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by anaguz on 15/12/17.
 */

public class SettingsFragment extends PreferenceFragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.opciones);

    }

    public SettingsFragment() {
    }
}

