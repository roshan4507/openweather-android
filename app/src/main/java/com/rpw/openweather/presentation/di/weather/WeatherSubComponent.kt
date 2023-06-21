package com.rpw.openweather.presentation.di.weather

import com.rpw.openweather.presentation.MainActivity
import dagger.Subcomponent

@WeatherScope
@Subcomponent(modules = [WeatherModule::class])
interface WeatherSubComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():WeatherSubComponent
    }
}