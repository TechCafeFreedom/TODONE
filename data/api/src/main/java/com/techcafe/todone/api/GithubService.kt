package com.techcafe.todone.api

import com.techcafe.todone.api.model.ContributorsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("orgs/{teamName}/members")
    suspend fun getContributorsMember(@Path("teamName") teamName: String, @Query("access_token") token: String): Response<ContributorsResponse>
}
