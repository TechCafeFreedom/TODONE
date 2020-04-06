package com.techcafe.todone.settings

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import androidx.lifecycle.observe
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat
import org.koin.android.viewmodel.ext.android.viewModel

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

        val sharedPref = activity?.getSharedPreferences(
            context?.getString(R.string.shared_pref_todone_key),
            Context.MODE_PRIVATE
        )

        preferenceManager?.findPreference<ListPreference>(DARK_THEME_KEY)?.also {
            it.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, newValue ->
                val nightMode = when (newValue as String) {
                    context?.getString(R.string.pref_theme_value_light) -> AppCompatDelegate.MODE_NIGHT_NO
                    context?.getString(R.string.pref_theme_value_dark) -> AppCompatDelegate.MODE_NIGHT_YES
                    context?.getString(R.string.pref_theme_value_default) -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                    else -> throw IllegalArgumentException("should not happen")
                }
                sharedPref?.edit {
                    putInt(context?.getString(R.string.shared_pref_mode_night_key), nightMode)
                }
                AppCompatDelegate.setDefaultNightMode(nightMode)
                return@OnPreferenceChangeListener true
            }
        }

    companion object {
        private const val DARK_THEME_KEY = "darkTheme"
    }
}
