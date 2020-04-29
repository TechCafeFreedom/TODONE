package com.techcafe.todone.repository.di

import com.techcafe.todone.repository.AuthRepository
import com.techcafe.todone.repository.TestRepository
import com.techcafe.todone.repository.impl.AuthRepositoryImpl
import com.techcafe.todone.repository.impl.TestRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<TestRepository> { TestRepositoryImpl(get(), get(), get(), get(), get(), get()) }
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}
