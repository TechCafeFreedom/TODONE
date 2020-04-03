package com.techcafe.todone.settings

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat
import org.koin.android.viewmodel.ext.android.viewModel

class SettingsFragment : PreferenceFragmentCompat() {

    private val viewModel: SettingsViewModel by viewModel()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferenceManager.findPreference<SwitchPreferenceCompat>(DARK_THEME_KEY).also {
            it?.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, newValue ->
                viewModel.setNightMode(newValue as Boolean)
                return@OnPreferenceChangeListener true
            }
        }
    }

    companion object {
        private const val DARK_THEME_KEY = "darkTheme"
    }
}
