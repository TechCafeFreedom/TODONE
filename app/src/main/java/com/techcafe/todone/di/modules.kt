package com.techcafe.todone.di

import com.techcafe.todone.api.di.apiModule
import com.techcafe.todone.auth.di.authModule
import com.techcafe.todone.db.di.dbModule
import com.techcafe.todone.repository.di.repositoryModule

val moduleList = listOf(
    apiModule,
    dbModule,
    repositoryModule,
    authModule
)
