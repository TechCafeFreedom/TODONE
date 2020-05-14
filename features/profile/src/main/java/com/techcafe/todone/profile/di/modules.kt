package com.techcafe.todone.profile.di

import com.techcafe.todone.profile.edit.EditProfileViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val profileModule = module {
    viewModel { EditProfileViewModel(get()) }
}
