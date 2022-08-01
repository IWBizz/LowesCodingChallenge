package com.example.lowescodingchallenge.api

import com.example.lowescodingchallenge.model.WeatherResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherService: WeatherService
) {

    fun getWeather(
        city: String, units: String
    ): Single<WeatherResponse> = weatherService.getWeatherData(city, units = units)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}