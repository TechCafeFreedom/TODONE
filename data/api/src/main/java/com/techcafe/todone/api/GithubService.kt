package com.techcafe.todone.api

import com.techcafe.todone.api.model.ContributorResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("orgs/TechCafeFreedom/members")
    suspend fun getContributorsMember(@Query("access_token") token: String): Response<ContributorResponse>
}
