package com.example.lowescodingchallenge.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.lowescodingchallenge.R
import com.example.lowescodingchallenge.databinding.WeatherDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherDetailFragment : Fragment(R.layout.weather_detail_fragment) {

    private val args by navArgs<WeatherDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        WeatherDetailFragmentBinding.bind(view).apply {
            val weatherContainer = args.weatherContainer
            val na = root.context.getString(R.string.na)

            tvTemp.text = weatherContainer.main?.temp?.toString() ?: na
            tvTempDescription.text = "Feels Like: " + weatherContainer.main?.feelsLike?.toString() ?: na
            tvForecast.text = weatherContainer.weather?.firstOrNull()?.main ?: na
            tvForecastDescription.text = weatherContainer.weather?.firstOrNull()?.description ?: na

        }
    }
}
