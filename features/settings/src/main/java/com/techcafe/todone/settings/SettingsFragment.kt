package com.techcafe.todone.settings

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.observe
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
                Log.d("TODONENIGHT", "スイッチ変更された！ $newValue")
                viewModel.setNightMode(newValue as Boolean)
                return@OnPreferenceChangeListener true
            }
        }

        // 本当はstateを使ってこっちで値の通知受け取りたいけどなぜかこない
//        viewModel.state.observe(viewLifecycleOwner) {
////            val nightMode = when (it.nightMode) {
////                NightMode.YES -> AppCompatDelegate.MODE_NIGHT_YES
////                NightMode.NO -> AppCompatDelegate.MODE_NIGHT_NO
////                NightMode.SYSTEM -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
////                NightMode.BATTERY -> AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
////            }
//            Log.d("TODONENIGHT", "state変更検知！ ${it.nightMode}")
////            AppCompatDelegate.setDefaultNightMode(nightMode)
//        }

        viewModel.nightMode.observe(viewLifecycleOwner) {
            Log.d("TODONENIGHT", "nightMode:ダークモードの切り替え検知 ${it}")
            val nightMode = when (it) {
                NightMode.YES -> AppCompatDelegate.MODE_NIGHT_YES
                NightMode.NO -> AppCompatDelegate.MODE_NIGHT_NO
                NightMode.SYSTEM -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                NightMode.BATTERY -> AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
            }
            AppCompatDelegate.setDefaultNightMode(nightMode)
        }
    }

    companion object {
        private const val DARK_THEME_KEY = "darkTheme"
    }
}
