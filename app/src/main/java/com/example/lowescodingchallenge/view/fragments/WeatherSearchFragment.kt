package com.example.lowescodingchallenge.view.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lowescodingchallenge.R
import com.example.lowescodingchallenge.databinding.WeatherSearchFragmentBinding
import com.example.lowescodingchallenge.model.WeatherContainer
import com.example.lowescodingchallenge.utilities.WeatherDataState
import com.example.lowescodingchallenge.view.MainActivity
import com.example.lowescodingchallenge.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherSearchFragment : Fragment(R.layout.weather_search_fragment) {

    private lateinit var binding: WeatherSearchFragmentBinding
    private val weatherViewModel by viewModels<WeatherViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = WeatherSearchFragmentBinding.bind(view).apply {
            weatherSearchBtn.setOnClickListener {
                val cityName = etSearch.text.toString()
                (requireActivity() as MainActivity).setTitle(cityName)
                weatherViewModel.loadWeatherList(cityName)
            }
        }

        weatherViewModel.weatherDataStateLD.observe(viewLifecycleOwner) { state ->
            when (state) {
                is WeatherDataState.Success -> toggleSuccess(state.data)
                is WeatherDataState.Error -> toggleError(state.msg)
                is WeatherDataState.Loading -> toggleLoader(true)
                is WeatherDataState.Idle -> {

                }
            }
        }
    }

    private fun toggleSuccess(data: List<WeatherContainer>) = with(binding) {
        toggleLoader(false)
        findNavController().navigate(WeatherSearchFragmentDirections.goToList(data.toTypedArray()))
        weatherViewModel.resetState()
        weatherSearchBtn.isEnabled = true
    }

    private fun toggleError(msg: String) = with(binding) {
        toggleLoader(false)
        ilSearch.error = msg
        ilSearch.isErrorEnabled = true
        weatherSearchBtn.isEnabled = true
    }

    private fun toggleLoader(isLoading: Boolean) = with(binding) {
        loader.isVisible = isLoading
        ilSearch.isErrorEnabled = false
        weatherSearchBtn.isEnabled = false
    }
}