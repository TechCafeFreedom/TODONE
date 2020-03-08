package com.techcafe.todone

import android.app.Application
import com.techcafe.todone.di.moduleList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(modules = moduleList)
        }
    }
}