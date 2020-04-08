package com.techcafe.todone.settings

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        preferenceManager.findPreference<SwitchPreferenceCompat>(DARK_THEME_KEY).also {
            it?.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, newValue ->
                val nightMode = if (newValue as Boolean) {
                    AppCompatDelegate.MODE_NIGHT_YES
                } else {
                    AppCompatDelegate.MODE_NIGHT_NO
                }
                sharedPref?.edit {
                    putInt("MODE_NIGHT", nightMode)
                }
                AppCompatDelegate.setDefaultNightMode(nightMode)
                return@OnPreferenceChangeListener true
            }
        }
    }

    companion object {
        private const val DARK_THEME_KEY = "darkTheme"
    }
}
