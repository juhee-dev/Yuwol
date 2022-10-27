package com.yuwol.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yuwol.databinding.ItemHomeChartBinding
import com.yuwol.model.Chart

class ChartAdapter : RecyclerView.Adapter<ChartAdapter.ViewHolder>() {
    // Adapter는 ViewHolder로 변경할 데이터를 가지고 있어야 함
    var dataList = mutableListOf<Chart>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeChartBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }
    // Adapter는 ViewHolder에 Data를 전달하는 방법을 정의해야 함
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }
    // Adapter는 전체 아이템의 수를 알아야 함
    override fun getItemCount(): Int = dataList.size

    class ViewHolder(private val binding: ItemHomeChartBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(chart: Chart){
            binding.ivChartCover.setImageResource(chart.cover)
            binding.tvChartTitle.text = chart.title
            binding.tvChartArtist.text = chart.artist
            binding.tvChartDifficulty.text = chart.difficulty
            binding.tvChartHigh.text = chart.high
            binding.tvChartExcitement.text = chart.excitement
            binding.tvChartRap.text = chart.rap
        }
    }
}