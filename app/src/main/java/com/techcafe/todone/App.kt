package com.techcafe.todone

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.BuildCompat
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

    // 別にこれ実行しなくても端末の設定に応じてダークモードに切り替わる
    private fun setupNightMode() {
        val nightMode = if (BuildCompat.isAtLeastQ()) {
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        } else {
            AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
        }
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }
}
