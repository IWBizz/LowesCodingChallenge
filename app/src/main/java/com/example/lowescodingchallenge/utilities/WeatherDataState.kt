package com.example.lowescodingchallenge.utilities

import com.example.lowescodingchallenge.model.WeatherContainer

sealed class WeatherDataState {
    data class Success(val data: List<WeatherContainer>) : WeatherDataState()
    data class Error(val msg: String) : WeatherDataState()
    object Loading : WeatherDataState()
    object Idle : WeatherDataState()
}
