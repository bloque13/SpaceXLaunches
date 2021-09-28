package com.example.jetpackcompose.interactors.launches

import com.example.jetpackcompose.data.dto.LaunchesResponse
import com.example.jetpackcompose.data.remote.SpaceXQuery
import com.example.jetpackcompose.data.remote.SpacexAPI
import com.example.jetpackcompose.domain.data.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class QueryLaunchesUseCase(
    private val api: SpacexAPI,
) {
    fun execute(query: SpaceXQuery
    ): Flow<DataState<LaunchesResponse>> = flow {
        try {
            emit(DataState.loading())

            val launches = getLaunchesFromNetwork(query)

            if (launches != null) {
                emit(DataState.success(launches))
            } else {
                throw Exception("Unable to load launches.")
            }

        } catch (e: Exception) {
            emit(DataState.error<LaunchesResponse>(e.message ?: "Unknown Error"))
        }
    }

    private suspend fun getLaunchesFromNetwork(query: SpaceXQuery): LaunchesResponse? {
        return api.getLaunches(query = query)
    }
}