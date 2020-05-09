package com.techcafe.todone.api.di

import com.google.firebase.auth.FirebaseAuth
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.techcafe.todone.api.AddHeaderInterceptor
import com.techcafe.todone.api.FirebaseService
import com.techcafe.todone.api.FirebaseServiceImpl
import com.techcafe.todone.api.GithubService
import com.techcafe.todone.api.TestService
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val QUALIFIER_TEST = "QUALIFIER_TEST"
private const val QUALIFIER_GITHUB = "QUALIFIER_GITHUB"

private const val BASE_URL_TEST = "https://todone-test-production.herokuapp.com"
private const val BASE_URL_GITHUB = "https://api.github.com/"

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
    single(qualifier = named(QUALIFIER_GITHUB)) {
        buildRetrofit(BASE_URL_GITHUB, get(), get())
    }
    single {
        get<Retrofit>().create(TestService::class.java)
    }
    single {
        get<Retrofit>().create(GithubService::class.java)

        single { FirebaseAuth.getInstance() }
        single<FirebaseService> { FirebaseServiceImpl(get()) }
    }
}

private fun buildRetrofit(baseUrl: String, okHttp: OkHttpClient, moshi: Moshi) =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttp)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
