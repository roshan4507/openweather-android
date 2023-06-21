package com.rpw.openweather.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rpw.openweather.domain.usecase.GetWeatherUseCase

class WeatherViewModelFactory(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherViewModel(getWeatherUseCase) as T
    }
}