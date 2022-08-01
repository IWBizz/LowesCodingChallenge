package com.example.lowescodingchallenge.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Main(
    @SerializedName("feels_like")
    val feelsLike: Double? = null,

    @SerializedName("grnd_level")
    val grndLevel: Int? = null,
    val humidity: Int? = null,
    val pressure: Int? = null,

    @SerializedName("sea_level")
    val seaLevel: Int? = null,
    val temp: Double? = null,

    @SerializedName("temp_kf")
    val tempKf: Double? = null,

    @SerializedName("temp_max")
    val tempMax: Double? = null,

    @SerializedName("temp_min")
    val tempMin: Double? = null
): Parcelable