package com.techcafe.todone.di

import com.example.usecase.di.useCaseModule
import com.techcafe.todone.api.di.apiModule
import com.techcafe.todone.auth.di.authModule
import com.techcafe.todone.board.di.boardModule
import com.techcafe.todone.db.di.dbModule
import com.techcafe.todone.profile.di.profileModule
import com.techcafe.todone.repository.di.repositoryModule
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
val moduleList = listOf(
    profileModule,
    apiModule,
    dbModule,
    repositoryModule,
    boardModule,
    useCaseModule,
    authModule
)
