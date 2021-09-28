package com.example.jetpackcompose.interactors.launches

import com.example.jetpackcompose.data.dto.Launch
import com.example.jetpackcompose.data.remote.SpacexAPI
import com.example.jetpackcompose.domain.data.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetLaunchesUseCase(
    private val api: SpacexAPI,
) {
    fun execute(
    ): Flow<DataState<List<Launch>>> = flow {
        try {
            emit(DataState.loading())

            val launches = getLaunchesFromNetwork()

            if (launches != null) {
                emit(DataState.success(launches))
            } else {
                throw Exception("Unable to get launches.")
            }

        } catch (e: Exception) {
            emit(DataState.error<List<Launch>>(e.message ?: "Unknown Error"))
        }
    }

    private suspend fun getLaunchesFromNetwork(): List<Launch> {
        return api.getLaunches()
    }
}