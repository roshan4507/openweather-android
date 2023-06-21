package com.rpw.openweather.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rpw.openweather.domain.usecase.GetWeatherUseCase

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
):ViewModel() {

    fun getWeatherData(city:String) = liveData {
        val weatherData = getWeatherUseCase.execute(city)
        emit(weatherData)
    }
}