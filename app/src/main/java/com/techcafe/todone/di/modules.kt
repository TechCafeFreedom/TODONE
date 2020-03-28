package com.techcafe.todone.di

import com.techcafe.todone.api.di.apiModule
import com.techcafe.todone.db.di.dbModule
import com.techcafe.todone.notifications.di.notificationsModule
import com.techcafe.todone.profile.di.profileModule
import com.techcafe.todone.repository.di.repositoryModule

val moduleList = listOf(
    profileModule,
    apiModule,
    dbModule,
    repositoryModule,
    notificationsModule
)
