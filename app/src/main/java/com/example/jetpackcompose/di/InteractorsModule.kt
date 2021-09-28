package com.example.jetpackcompose.di

import com.example.jetpackcompose.data.remote.SpacexAPI
import com.example.jetpackcompose.interactors.launches.GetLaunchesUseCase
import com.example.jetpackcompose.interactors.launches.QueryLaunchesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object InteractorsModule {

    @ViewModelScoped
    @Provides
    fun provideGetLaunchesUseCase(
        api: SpacexAPI,
    ): GetLaunchesUseCase {
        return GetLaunchesUseCase(
            api = api,
        )
    }

    @ViewModelScoped
    @Provides
    fun provideLaunchesUseCase(
        api: SpacexAPI,
    ): QueryLaunchesUseCase {
        return QueryLaunchesUseCase(
            api = api,
        )
    }
}