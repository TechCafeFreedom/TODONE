package com.techcafe.profile.di

import com.techcafe.profile.edit.ProfileEditorViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val profileModule = module {
    viewModel { ProfileEditorViewModel(get()) }
}