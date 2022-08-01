package com.example.lowescodingchallenge.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val city: City? = null,
    val cnt: Int? = null,
    val cod: String? = null,

    @SerializedName("list")
    val list: List<WeatherContainer>? = null,

    val message: Int? = null
)