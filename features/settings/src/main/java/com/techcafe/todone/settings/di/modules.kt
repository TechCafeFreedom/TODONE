package com.techcafe.todone.settings.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val settingsModules = module {
    viewModel { SettingsViewModel() }
}