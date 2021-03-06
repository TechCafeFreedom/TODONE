package com.techcafe.todone

import android.app.Application
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
open class App : Application() {

    override fun onCreate() {
        super.onCreate()

        setupNightMode()
        initializeTimber()
    }

    private fun initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun setupNightMode() {
        val defaultNightMode = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
        } else {
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        }
        val sharedPred = applicationContext.getSharedPreferences(
            applicationContext.getString(R.string.shared_pref_todone_key),
            Context.MODE_PRIVATE
        )
        val nightMode = sharedPred.getInt(
            applicationContext.getString(R.string.shared_pref_mode_night_key),
            defaultNightMode
        )
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }
}
