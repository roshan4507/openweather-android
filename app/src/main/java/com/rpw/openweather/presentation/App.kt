package com.rpw.openweather.presentation

import android.app.Application
import com.rpw.openweather.BuildConfig
import com.rpw.openweather.presentation.di.Injector
import com.rpw.openweather.presentation.di.core.AppComponent
import com.rpw.openweather.presentation.di.core.AppModule
import com.rpw.openweather.presentation.di.core.DaggerAppComponent
import com.rpw.openweather.presentation.di.core.NetModule
import com.rpw.openweather.presentation.di.core.RemoteDataModule
import com.rpw.openweather.presentation.di.weather.WeatherSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createWeatherSubComponent(): WeatherSubComponent {
        return appComponent.weatherSubComponent().create()
    }
}