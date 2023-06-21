package com.rpw.openweather.presentation.di

import com.rpw.openweather.presentation.di.weather.WeatherSubComponent

interface Injector {
    fun createWeatherSubComponent():WeatherSubComponent
}