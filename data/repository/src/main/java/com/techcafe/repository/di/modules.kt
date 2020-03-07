package com.techcafe.repository.di

import com.techcafe.repository.TestRepository
import com.techcafe.repository.impl.TestRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<TestRepository> { TestRepositoryImpl() }
}