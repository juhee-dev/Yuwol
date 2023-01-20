package com.yuwol.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yuwol.databinding.ItemMyCommentBinding
import com.yuwol.model.Chart

class MycommentAdapter : RecyclerView.Adapter<MycommentAdapter.ViewHolder>() {

    var dataList = mutableListOf<Chart>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMyCommentBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolder(private val binding: ItemMyCommentBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(chart: Chart){
            binding.ivItemMyCommentCover.setImageResource(chart.cover)
            binding.tvItemMyCommentTitle.text = chart.title
            binding.tvItemMyCommentArtist.text = chart.artist
            binding.tvItemMyCommentDifficulty.text = chart.difficulty
            binding.tvItemMyCommentMood.text = chart.mood
            binding.tvItemMyCommentHigh.text = chart.high
            binding.tvItemMyCommentLow.text = chart.low
            binding.tvItemMyCommentRap.text = chart.rap
        }
    }
}