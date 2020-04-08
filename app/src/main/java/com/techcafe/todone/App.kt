package com.techcafe.todone

import android.app.Application
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import com.techcafe.todone.di.moduleList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        setupNightMode()

        initializeKoin()
        initializeTimber()
    }

    private fun initializeKoin() {
        startKoin {
            androidContext(this@App)
            modules(modules = moduleList)
        }
    }

    private fun initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun setupNightMode() {
        val sharedPref = applicationContext?.getSharedPreferences("", Context.MODE_PRIVATE)
        val nightMode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        } else {
            AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
        }
        val defKnightMode = sharedPref?.getInt("MODE_NIGHT", nightMode)
        defKnightMode?.let {
            AppCompatDelegate.setDefaultNightMode(defKnightMode)
        }
    }
}
