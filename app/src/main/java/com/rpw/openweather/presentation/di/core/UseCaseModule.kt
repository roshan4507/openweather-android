package com.rpw.openweather.presentation.di.core

import com.rpw.openweather.domain.repository.WeatherRepository
import com.rpw.openweather.domain.usecase.GetWeatherUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetWeathersUseCase(weatherRepository: WeatherRepository): GetWeatherUseCase {
        return GetWeatherUseCase(weatherRepository)
    }
}