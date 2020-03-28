package com.techcafe.todone.notifications.di

import com.techcafe.todone.notifications.ui.NotificationsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val notificationsModule = module {
    viewModel { NotificationsViewModel() }
}