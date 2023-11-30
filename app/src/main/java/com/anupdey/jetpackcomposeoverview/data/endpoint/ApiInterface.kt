package com.anupdey.jetpackcomposeoverview.data.endpoint

import com.anupdey.jetpackcomposeoverview.data.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String = "Android",
        @Query("sort") sortBy: String = "stars",
    ): SearchResponse

}