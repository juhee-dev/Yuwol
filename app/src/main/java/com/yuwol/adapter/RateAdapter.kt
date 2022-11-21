package com.yuwol.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yuwol.R
import com.yuwol.databinding.ItemRatingBinding
import com.yuwol.fragment.ChartAllFragment
import com.yuwol.fragment.FirstRatingFragment
import com.yuwol.fragment.RatingFragment
import com.yuwol.model.Rate

class RateAdapter(var link:RatingFragment.rateAdapterToList) : RecyclerView.Adapter<RateAdapter.ViewHolder>() {
    // Adapter는 ViewHolder로 변경할 데이터를 가지고 있어야 함
    var dataList = mutableListOf<Rate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRatingBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }
    // Adapter는 ViewHolder에 Data를 전달하는 방법을 정의해야 함
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataList[position])
        holder.itemView.setOnClickListener {
            val song = dataList[position]
            link.getSongId(song)
        }
    }
    // Adapter는 전체 아이템의 수를 알아야 함
    override fun getItemCount(): Int = dataList.size

    class ViewHolder(private val binding: ItemRatingBinding) : RecyclerView.ViewHolder(binding.root){
        private val context = binding.root.context

        fun onBind(chart: Rate){
            binding.ratingCover.setImageResource(chart.cover)
            binding.ratingTitle.text = chart.title

        }
    }
}