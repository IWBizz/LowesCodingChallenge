package com.example.lowescodingchallenge.api

import com.example.lowescodingchallenge.model.WeatherResponse
import com.example.lowescodingchallenge.utilities.WeatherUnits
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("forecast")
    fun getWeatherData(
        @Query("q") city: String,
        @Query("appid") apiKey: String = "65d00499677e59496ca2f318eb68c049",
        @Query("units") units: String = WeatherUnits.IMPERIAL.name
    ): Single<WeatherResponse>
}