package com.yuwol.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yuwol.databinding.ItemMyRateBinding
import com.yuwol.model.Chart

class MyrateAdapter : RecyclerView.Adapter<MyrateAdapter.ViewHolder>() {

    var dataList = mutableListOf<Chart>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMyRateBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolder(private val binding: ItemMyRateBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(chart: Chart){
            binding.ivMyRateCover.setImageResource(chart.cover)

            binding.tvMyRateTitle.text = chart.title
            binding.tvMyRateArtist.text = chart.artist
            binding.tvMyRateDifficulty.text = chart.difficulty
            binding.tvMyRateMood.text = chart.mood
            binding.tvMyRateHigh.text = chart.high
            binding.tvMyRateLow.text = chart.low
            binding.tvMyRateRap.text = chart.rap
        }
    }
}