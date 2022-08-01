package com.example.lowescodingchallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lowescodingchallenge.R
import com.example.lowescodingchallenge.databinding.WeatherListItemBinding
import com.example.lowescodingchallenge.model.WeatherContainer


class WeatherAdapter(
    private val weatherContainerList: List<WeatherContainer>,
    private val weatherContainerSelected: (WeatherContainer) -> Unit
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = WeatherListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false).let {
        WeatherViewHolder(it).apply {
            it.root.setOnClickListener {
                weatherContainerSelected.invoke(weatherContainerList[bindingAdapterPosition])
            }
        }
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.load(weatherContainerList[position])
    }

    override fun getItemCount() = weatherContainerList.size

    class WeatherViewHolder(
        private val binding: WeatherListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun load(weatherContainer: WeatherContainer) = with(binding) {
            val na = root.context.getString(R.string.na)
            tvForecast.text = weatherContainer.weather?.firstOrNull()?.main ?: na
            val temp = weatherContainer.main?.temp?.toString() ?: na
            tvTemp.text = root.context.getString(R.string.args_temp, temp)
        }
    }

}