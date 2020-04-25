package com.techcafe.todone.api.di

import com.google.firebase.auth.FirebaseAuth
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.techcafe.todone.api.AddHeaderInterceptor
import com.techcafe.todone.api.FirebaseService
import com.techcafe.todone.api.FirebaseServiceImpl
import com.techcafe.todone.api.TestService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://todone-test-production.herokuapp.com"

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
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(MoshiConverterFactory.create(get<Moshi>()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
    single {
        get<Retrofit>().create(TestService::class.java)
    }

    single { FirebaseAuth.getInstance() }
    single<FirebaseService> { FirebaseServiceImpl(get()) }
}
