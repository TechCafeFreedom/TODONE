package com.techcafe.todone.api

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AddHeaderInterceptor(
    private val service: FirebaseService
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // OkHttpがよしなにスレッドを変えてくれているため一旦runBlockingで
        val token = runCatching {
            runBlocking { service.getToken() }
        }.getOrThrow()

        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()

        return chain.proceed(newRequest)
    }
}
