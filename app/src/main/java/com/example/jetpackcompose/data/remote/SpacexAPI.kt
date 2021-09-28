package com.example.jetpackcompose.data.remote

import com.example.jetpackcompose.data.dto.Launch
import com.example.jetpackcompose.data.dto.LaunchesResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SpacexAPI {
    @GET("/v4/launches")
    suspend fun getLaunches(): List<Launch>

    @POST("/v4/launches/query")
    suspend fun getLaunches(@Body query: SpaceXQuery): LaunchesResponse
}