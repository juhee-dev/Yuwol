package com.yuwol.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yuwol.databinding.ItemRatingBinding
import com.yuwol.model.Rate

class RateAdapter : RecyclerView.Adapter<RateAdapter.ViewHolder>() {
    // Adapter는 ViewHolder로 변경할 데이터를 가지고 있어야 함
    var dataList = mutableListOf<Rate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRatingBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }
    // Adapter는 ViewHolder에 Data를 전달하는 방법을 정의해야 함
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }
    // Adapter는 전체 아이템의 수를 알아야 함
    override fun getItemCount(): Int = dataList.size

    class ViewHolder(private val binding: ItemRatingBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(chart: Rate){
            binding.ratingCover.setImageResource(chart.cover)
            binding.ratingRank.text = chart.rank
            binding.ratingTitle.text = chart.title

        }
    }
}