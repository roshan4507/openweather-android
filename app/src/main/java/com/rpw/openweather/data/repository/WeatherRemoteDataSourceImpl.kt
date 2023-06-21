package com.rpw.openweather.data.repository

import com.rpw.openweather.data.api.WeatherService
import com.rpw.openweather.data.model.WeatherDataResponse
import retrofit2.Response

class WeatherRemoteDataSourceImpl(
    private val weatherService: WeatherService
) : WeatherRemoteDataSource {
    override suspend fun getWeatherData(city: String): Response<WeatherDataResponse> {
        return weatherService.getCityWeatherData(city)
    }
}