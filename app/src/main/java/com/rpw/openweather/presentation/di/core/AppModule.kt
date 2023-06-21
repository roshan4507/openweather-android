package com.rpw.openweather.presentation.di.core

import android.content.Context
import com.rpw.openweather.presentation.di.weather.WeatherSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [WeatherSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return context.applicationContext
    }
}