package com.techcafe.todone.api

import com.techcafe.todone.api.model.BoardResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MockService {

    @GET("/boards")
    suspend fun getBoards(
        @Query("board") boardNum: Int = 3,
        @Query("kabnan") kabnanNum: Int = 3,
        @Query("card") cardNum: Int = 3,
        @Query("label") labelNum: Int = 3,
        @Query("code") statusCode: Int? = null
    ): List<BoardResponse>
}