package com.example.lowescodingchallenge.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherContainer(
    val clouds: Clouds? = null,
    val dt: Int? = null,

    @SerializedName("dt_txt")
    val dtTxt: String? = null,

    val main: Main? = null,
    val pop: Double? = null,
    val rain: Rain? = null,
    val sys: Sys? = null,
    val visibility: Int? = null,
    val weather: List<Weather>? = null,
    val wind: Wind? = null
) : Parcelable