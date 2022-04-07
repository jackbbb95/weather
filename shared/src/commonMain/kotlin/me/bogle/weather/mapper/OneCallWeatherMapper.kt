package me.bogle.weather.mapper

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import me.bogle.weather.api.response.oneCallWeather.*
import me.bogle.weather.model.oneCallWeather.*

class OneCallWeatherMapper : Mapper<OneCallWeatherResponse, OneCallWeather> {

    override suspend fun map(model: OneCallWeatherResponse): OneCallWeather {
        val current = model.current.mapToCurrent()

        val dailyList = model.daily.map { it.mapToDaily() }

        val hourlyList = model.hourly.map { it.mapToHourly() }

        val minutelyList = model.minutely.map { it.mapToMinutely() }

        return OneCallWeather(
            current = current,
            dailyList = dailyList,
            hourlyList = hourlyList,
            minutelyList = minutelyList
        )
    }

    private fun CurrentWeatherResponse.mapToCurrent(): Current =
        Current(
            dateTime = Instant.fromEpochSeconds(dt)
                .toLocalDateTime(TimeZone.currentSystemDefault()),
            clouds = clouds,
            dewPoint = dewPoint,
            feelsLike = feelsLike,
            humidity = humidity,
            pressure = pressure,
            rainAmount = rain?.h,
            snowAmount = snow?.h,
            sunrise = sunrise,
            sunset = sunset,
            temp = temp,
            uvi = uvi,
            visibility = visibility,
            weather = weather?.map { weather ->
                WeatherType(
                    description = weather.description,
                    icon = weather.icon,
                    id = weather.id,
                    main = weather.main
                )
            },
            windDeg = windDeg,
            windGust = windGust,
            windSpeed = windSpeed
        )

    private fun DailyWeatherResponse.mapToDaily(): Daily =
        Daily(
            dateTime = Instant.fromEpochSeconds(dt)
                .toLocalDateTime(TimeZone.currentSystemDefault()),
            clouds = clouds,
            dewPoint = dewPoint,
            feelsLike = feelsLike?.let { feelsLike ->
                Daily.FeelsLike(
                    day = feelsLike.day,
                    eve = feelsLike.eve,
                    morn = feelsLike.morn,
                    night = feelsLike.night
                )
            },
            humidity = humidity,
            moonPhase = moonPhase,
            moonrise = moonrise,
            moonset = moonset,
            pop = pop,
            pressure = pressure,
            rain = rain,
            snow = snow,
            sunrise = sunrise,
            sunset = sunset,
            temp = temp?.let { temp ->
                Daily.Temperatures(
                    day = temp.day,
                    eve = temp.eve,
                    max = temp.max,
                    min = temp.min,
                    morn = temp.morn,
                    night = temp.night
                )
            },
            uvi = uvi,
            weather = weather?.map { weather ->
                WeatherType(
                    description = weather.description,
                    icon = weather.icon,
                    id = weather.id,
                    main = weather.main
                )
            },
            windDeg = windDeg,
            windGust = windGust,
            windSpeed = windSpeed
        )

    private fun HourlyWeatherResponse.mapToHourly(): Hourly =
        Hourly(
            dateTime = Instant.fromEpochSeconds(dt)
                .toLocalDateTime(TimeZone.currentSystemDefault()),
            clouds = clouds,
            dewPoint = dewPoint,
            feelsLike = feelsLike,
            humidity = humidity,
            pop = pop,
            pressure = pressure,
            rainAmount = rain?.h,
            snowAmount = snow?.h,
            temp = temp,
            uvi = uvi,
            visibility = visibility,
            weather = weather?.map { weather ->
                WeatherType(
                    description = weather.description,
                    icon = weather.icon,
                    id = weather.id,
                    main = weather.main
                )
            },
            windDeg = windDeg,
            windGust = windGust,
            windSpeed = windSpeed
        )

    private fun MinutelyWeatherResponse.mapToMinutely(): Minutely =
        Minutely(
            dateTime = Instant.fromEpochSeconds(dt)
                .toLocalDateTime(TimeZone.currentSystemDefault()),
            precipitation = precipitation
        )
}