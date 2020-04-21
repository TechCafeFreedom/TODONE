package com.techcafe.todone.auth.di

import com.techcafe.todone.auth.signup.SignUpViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel { SignUpViewModel(get()) }
}
