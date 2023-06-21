package com.rpw.openweather.presentation.di.core

import com.rpw.openweather.data.api.WeatherService
import com.rpw.openweather.data.repository.WeatherRemoteDataSource
import com.rpw.openweather.data.repository.WeatherRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val city: String) {

    @Singleton
    @Provides
    fun provideWeatherRemoteDataSource(weatherService: WeatherService): WeatherRemoteDataSource {
        return WeatherRemoteDataSourceImpl(weatherService)
    }
}