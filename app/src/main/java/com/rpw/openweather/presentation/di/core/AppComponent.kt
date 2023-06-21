package com.rpw.openweather.presentation.di.core

import com.rpw.openweather.presentation.di.weather.WeatherSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    fun weatherSubComponent():WeatherSubComponent.Factory
}