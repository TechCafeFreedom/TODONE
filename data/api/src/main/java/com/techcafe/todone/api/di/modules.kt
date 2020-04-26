package com.techcafe.todone.api.di

import com.google.firebase.auth.FirebaseAuth
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.techcafe.todone.api.*
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val QUALIFIER_TEST = "QUALIFIER_TEST"
private const val QUALIFIER_MOCK = "QUALIFIER_MOCK"

private const val BASE_URL_TEST = "https://todone-test-production.herokuapp.com"
private const val BASE_URL_MOCK = "https://todo-mock-production.herokuapp.com/"

@ExperimentalCoroutinesApi
val apiModule = module {
    single {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    single {
        OkHttpClient.Builder()
            .readTimeout(1000, TimeUnit.MILLISECONDS)
            .connectTimeout(1000, TimeUnit.MILLISECONDS)
            .addInterceptor(AddHeaderInterceptor(get()))
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }
    single(qualifier = named(QUALIFIER_TEST)) {
        buildRetrofit(BASE_URL_TEST, get(), get())
    }
    single(qualifier = named(QUALIFIER_MOCK)) {
        buildRetrofit(BASE_URL_MOCK, get(), get())
    }
    single {
        get<Retrofit>(qualifier = named(QUALIFIER_TEST)).create(TestService::class.java)
    }
    single {
        get<Retrofit>(qualifier = named(QUALIFIER_MOCK)).create(MockService::class.java)
    }
    single { FirebaseAuth.getInstance() }
    single<FirebaseService> { FirebaseServiceImpl(get()) }
}

private fun buildRetrofit(baseUrl: String, okHttp: OkHttpClient, moshi: Moshi) =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttp)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

