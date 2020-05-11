package com.example.usecase.di

import com.example.usecase.GetLabelsUseCase
import com.example.usecase.GetLabelsUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetLabelsUseCase> { GetLabelsUseCaseImpl(get()) }
}