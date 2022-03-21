package com.example.animalhandbook.settings

import android.os.Bundle
import android.preference.PreferenceFragment
import com.example.animalhandbook.R

class SettingsFragment: PreferenceFragment (){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preference_screen)
    }
}