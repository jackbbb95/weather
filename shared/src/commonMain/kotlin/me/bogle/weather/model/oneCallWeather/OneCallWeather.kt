package me.bogle.weather.model.oneCallWeather

data class OneCallWeather(
    val current: Current,
    val dailyList: List<Daily>,
    val hourlyList: List<Hourly>,
    val minutelyList: List<Minutely>,
)