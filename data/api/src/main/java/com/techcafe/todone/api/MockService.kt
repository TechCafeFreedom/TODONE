package com.techcafe.todone.api

import com.techcafe.todone.api.model.LabelResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MockService {

    // それぞれ何個欲しいとかはよしなにここをいじってくださし
    @GET("/boards/{board_id}/labels")
    suspend fun getLabels(
        @Path("board_id") id: Int = 0,
        @Query("label") labelNum: Int = 3,
        @Query("code") statusCode: Int? = null
    ): List<LabelResponse>
}