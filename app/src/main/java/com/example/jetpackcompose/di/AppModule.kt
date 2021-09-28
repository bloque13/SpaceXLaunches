package com.example.jetpackcompose.di

import android.content.Context
import com.example.jetpackcompose.common.Constants
import com.example.jetpackcompose.data.remote.SpacexAPI
import com.example.jetpackcompose.data.repository.SpacexRepositoryImpl
import com.example.jetpackcompose.domain.repository.SpacexRepository
import com.example.jetpackcompose.interactors.launches.GetLaunchesUseCase
import com.example.jetpackcompose.interactors.launches.QueryLaunchesUseCase
import com.example.jetpackcompose.presentation.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

    @Provides
    @Singleton
    fun provideSpacexAPI(): SpacexAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SpacexAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideSpacexRepository(api: SpacexAPI): SpacexRepository {
        return SpacexRepositoryImpl(api)
    }

}