package com.techcafe.todone.usecase.di

import com.techcafe.todone.usecase.GetLabelsUseCase
import com.techcafe.todone.usecase.GetLabelsUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetLabelsUseCase> {
        GetLabelsUseCaseImpl(
            get()
        )
    }
}