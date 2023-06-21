package com.rpw.openweather.presentation.di.weather

import com.rpw.openweather.domain.usecase.GetWeatherUseCase
import com.rpw.openweather.presentation.weather.WeatherViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class WeatherModule {
    @WeatherScope
    @Provides
    fun provideWeatherViewModelFactory(
        getWeatherUseCase: GetWeatherUseCase
    ): WeatherViewModelFactory {
        return WeatherViewModelFactory(getWeatherUseCase)
    }
}