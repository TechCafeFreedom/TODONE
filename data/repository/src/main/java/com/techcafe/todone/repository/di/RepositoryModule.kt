package com.techcafe.todone.repository.di

import com.techcafe.todone.repository.AuthRepository
import com.techcafe.todone.repository.TestRepository
import com.techcafe.todone.repository.impl.AuthRepositoryImpl
import com.techcafe.todone.repository.impl.TestRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindTestRepository(testRepositoryImpl: TestRepositoryImpl): TestRepository

    @Singleton
    @Binds
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}
