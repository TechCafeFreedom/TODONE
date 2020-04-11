package com.techcafe.todone.api

import com.techcafe.todone.api.model.AuthTestResponse
import retrofit2.Response
import retrofit2.http.GET

interface TestService {
    // base url: https://todone-test-production.herokuapp.com
    @GET("/test")
    suspend fun getAuthTest(): Response<AuthTestResponse>
}
