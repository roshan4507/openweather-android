package com.rpw.openweather.data.api

import com.rpw.openweather.BuildConfig
import com.rpw.openweather.data.model.WeatherDataResponse
import com.rpw.openweather.data.util.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    suspend fun getCityWeatherData(
        @Query("q") q: String = "Nasik",
        @Query("units") units: String = AppConstants.WEATHER_UNIT,
        @Query("appid") appid: String = BuildConfig.API_KEY
    ): Response<WeatherDataResponse>
}