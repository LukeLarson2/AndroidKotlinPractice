package com.example.kotlinpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class DailyForecastViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tempText : TextView = view.findViewById(R.id.tempText)
    private val descriptionText : TextView = view.findViewById(R.id.descriptionText)

    fun bind(dailyForecast: DailyForecast) {
        tempText.text = formatTempForDisplay(dailyForecast.temp)
        descriptionText.text = dailyForecast.description
    }
}

class DailyForecastAdapter(
    private val clickHandler: (DailyForecast) -> Unit
) : ListAdapter<DailyForecast, DailyForecastViewHolder>(DIFF_CONFIG) {


    companion object {
        val DIFF_CONFIG = object: DiffUtil.ItemCallback<DailyForecast>() {
            override fun areItemsTheSame(oldItem: DailyForecast, newItem: DailyForecast): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(
                oldItem: DailyForecast,
                newItem: DailyForecast
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyForecastViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_daily_forecast, parent, false)
        return DailyForecastViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DailyForecastViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            clickHandler(getItem(position))
        }
    }
}