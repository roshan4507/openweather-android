package com.rpw.openweather.data.repository

import com.rpw.openweather.data.model.WeatherDataResponse
import retrofit2.Response

interface WeatherRemoteDataSource {

    suspend fun getWeatherData(city:String):Response<WeatherDataResponse>
}