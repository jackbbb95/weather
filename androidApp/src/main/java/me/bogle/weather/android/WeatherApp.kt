package me.bogle.weather.android

import android.app.Application
import me.bogle.weather.android.di.appModule
import me.bogle.weather.di.commonModule
import me.bogle.weather.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class WeatherApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@WeatherApp)
            modules(appModule)
            modules(appModule, commonModule)
        }
    }
}