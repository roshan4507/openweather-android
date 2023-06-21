package com.rpw.openweather.domain.repository

import com.rpw.openweather.data.model.WeatherDataResponse
import retrofit2.Response

interface WeatherRepository {
    suspend fun getWeatherData(city: String): WeatherDataResponse?
}