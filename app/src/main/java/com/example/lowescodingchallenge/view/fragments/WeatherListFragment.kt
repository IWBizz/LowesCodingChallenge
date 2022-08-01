package com.example.lowescodingchallenge.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lowescodingchallenge.R
import com.example.lowescodingchallenge.adapter.WeatherAdapter
import com.example.lowescodingchallenge.databinding.WeatherListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherListFragment : Fragment(R.layout.weather_list_fragment) {

    private val args by navArgs<WeatherListFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        WeatherListFragmentBinding.bind(view).apply {
            rvWeather.adapter = WeatherAdapter(args.weatherContainerList.toList()) {
                findNavController().navigate(WeatherListFragmentDirections.goToDetail(it))
            }
        }
    }
}