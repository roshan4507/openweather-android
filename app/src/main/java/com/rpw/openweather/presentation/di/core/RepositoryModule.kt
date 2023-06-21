package com.rpw.openweather.presentation.di.core

import com.rpw.openweather.data.repository.WeatherRemoteDataSource
import com.rpw.openweather.data.repository.WeatherRepositoryImpl
import com.rpw.openweather.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideWeatherRepositoryModule(
        weatherRemoteDataSource: WeatherRemoteDataSource
    ): WeatherRepository {
        return WeatherRepositoryImpl(
            weatherRemoteDataSource
        )
    }
}