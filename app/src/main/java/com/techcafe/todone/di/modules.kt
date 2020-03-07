package com.techcafe.todone.di

import com.techcafe.api.di.apiModule
import com.techcafe.db.di.dbModule
import com.techcafe.profile.di.profileModule
import com.techcafe.repository.di.repositoryModule

val moduleList = listOf(
    profileModule,
    apiModule,
    dbModule,
    repositoryModule
)