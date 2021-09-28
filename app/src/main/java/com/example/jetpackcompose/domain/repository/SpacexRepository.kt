package com.example.jetpackcompose.domain.repository

import com.example.jetpackcompose.data.dto.Launch

interface SpacexRepository {

    suspend fun getLaunches(): List<Launch>

}