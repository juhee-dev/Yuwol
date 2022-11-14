package com.yuwol.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yuwol.databinding.ItemHomeChartBinding
import com.yuwol.model.Chart

class ChartAdapter : RecyclerView.Adapter<ChartAdapter.ViewHolder>() {

    var dataList = mutableListOf<Chart>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeChartBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolder(private val binding: ItemHomeChartBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(chart: Chart){
            binding.ivChartCover.setImageResource(chart.cover)
            binding.tvChartRank.text = chart.rank
            binding.tvChartTitle.text = chart.title
            binding.tvChartArtist.text = chart.artist
            binding.tvChartDifficulty.text = chart.difficulty
            binding.tvChartMood.text = chart.mood
            binding.tvChartHigh.text = chart.high
            binding.tvChartLow.text = chart.low
            binding.tvChartRap.text = chart.rap
        }
    }
}