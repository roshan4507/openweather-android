package com.rpw.openweather.domain.usecase

import com.rpw.openweather.data.model.WeatherDataResponse
import com.rpw.openweather.domain.repository.WeatherRepository
import retrofit2.Response


class GetWeatherUseCase(private val weatherRepository: WeatherRepository) {

    suspend fun execute(city:String): WeatherDataResponse? = weatherRepository.getWeatherData(city)

}