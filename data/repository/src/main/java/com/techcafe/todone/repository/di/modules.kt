package com.techcafe.todone.repository.di

import com.techcafe.todone.repository.AuthRepository
import com.techcafe.todone.repository.TestRepository
import com.techcafe.todone.repository.impl.AuthRepositoryImpl
import com.techcafe.todone.repository.impl.TestRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
<<<<<<< HEAD
    single<TestRepository> { TestRepositoryImpl(get(), get(), get(), get(), get(), get(), get()) }
=======
    single<TestRepository> { TestRepositoryImpl(get(), get(), get(), get(), get()) }
    single<AuthRepository> { AuthRepositoryImpl(get()) }
>>>>>>> e638e7cc2d39bdabffcfef4f05f7782bc21206d5
}
