package com.example.jetpackcompose.data.repository

import com.example.jetpackcompose.data.dto.Launch
import com.example.jetpackcompose.data.remote.SpacexAPI
import com.example.jetpackcompose.domain.repository.SpacexRepository
import javax.inject.Inject


class SpacexRepositoryImpl @Inject constructor(
    private val api: SpacexAPI
) : SpacexRepository {

    override suspend fun getLaunches(): List<Launch> {
        return api.getLaunches()
    }
}