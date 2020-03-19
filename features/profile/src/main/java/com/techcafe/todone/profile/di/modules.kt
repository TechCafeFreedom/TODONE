package com.techcafe.todone.profile.di

import com.techcafe.todone.profile.edit.ProfileEditorViewModel
import com.techcafe.todone.repository.TestRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val profileModule = module {
    viewModel { ProfileEditorViewModel(get()) }
}