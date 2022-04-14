package me.bogle.weather.di

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import io.ktor.http.*
import me.bogle.weather.api.WeatherApi
import me.bogle.weather.mapper.OneCallWeatherMapper
import me.bogle.weather.repository.WeatherRepository
import me.bogle.weather.usecase.GetCurrentLocationCoordinatesUseCase
import me.bogle.weather.usecase.GetOneCallWeatherUseCase
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule, networkModule, usecaseModule, mapperModule)
}

// called by iOS etc
fun initKoin() = initKoin { }

val commonModule = module {
    single { WeatherRepository(get(), get()) }
    single { WeatherApi(get()) }
}

val networkModule = module {
    single {
        HttpClient {
            install(JsonFeature) {
                acceptContentTypes = acceptContentTypes + ContentType.Application.Json
            }
            install(Logging) {
                level = LogLevel.BODY
            }
        }
    }
}

val usecaseModule = module {
    single { GetCurrentLocationCoordinatesUseCase() }
    single { GetOneCallWeatherUseCase(get()) }
}

val mapperModule = module {
    single { OneCallWeatherMapper() }
}