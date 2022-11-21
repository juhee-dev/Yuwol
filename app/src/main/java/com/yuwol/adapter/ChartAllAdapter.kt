package com.yuwol.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yuwol.databinding.ItemChartAllBinding
import com.yuwol.model.Chart

class ChartAllAdapter : RecyclerView.Adapter<ChartAllAdapter.ViewHolder>() {

    var dataList = mutableListOf<Chart>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemChartAllBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolder(private val binding: ItemChartAllBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(chart: Chart){
            binding.ivItemChartAllCover.setImageResource(chart.cover)
            binding.tvItemChartAllRank.text = chart.rank
            binding.tvItemChartAllTitle.text = chart.title
            binding.tvItemChartAllArtist.text = chart.artist
            binding.tvItemChartAllDifficulty.text = chart.difficulty
            binding.tvItemChartAllMood.text = chart.mood
        }
    }
}