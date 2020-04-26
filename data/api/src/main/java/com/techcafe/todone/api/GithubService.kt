package com.techcafe.todone.api

import com.techcafe.todone.api.model.ContributorsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("orgs/{teamName}")
    suspend fun getContributorsMember(@Path("teamName") teamName: String): Response<ContributorsResponse>

}