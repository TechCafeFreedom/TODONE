package com.techcafe.todone.settings

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferenceManager.findPreference<SwitchPreferenceCompat>(DARK_THEME_KEY).also {
            it?.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, newValue ->
                if (newValue as Boolean) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                return@OnPreferenceChangeListener true
            }
        }
    }

    companion object {
        private const val DARK_THEME_KEY = "darkTheme"
    }
}
