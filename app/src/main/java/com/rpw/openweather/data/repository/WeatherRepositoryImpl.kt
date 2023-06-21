package com.rpw.openweather.data.repository

import com.rpw.openweather.data.model.WeatherDataResponse
import com.rpw.openweather.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherRemoteDataSource: WeatherRemoteDataSource
) : WeatherRepository {
    override suspend fun getWeatherData(city: String): WeatherDataResponse {
        return getWeatherDataFromAPI(city)
    }

    private suspend fun getWeatherDataFromAPI(city: String): WeatherDataResponse {

        lateinit var weatherResponse: WeatherDataResponse

        try {
            val response = weatherRemoteDataSource.getWeatherData(city)
            val body = response.body()
            if (body != null) {
                weatherResponse = response.body()!!
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return weatherResponse
    }
}