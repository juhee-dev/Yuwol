package com.yuwol.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yuwol.databinding.ItemMyLikesBinding
import com.yuwol.model.Chart

class MylikesAdapter: RecyclerView.Adapter<MylikesAdapter.ViewHolder>() {

    var dataList = mutableListOf<Chart>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMyLikesBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataList[position])

    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolder(private val binding: ItemMyLikesBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(song: Chart){
            binding.ivItemMyLikesCover.setImageResource(song.cover)
            binding.tvItemMyLikesTitle.text = song.title
            binding.tvItemMyLikesArtist.text = song.artist
            binding.tvItemMyLikesDifficulty.text = song.difficulty
            binding.tvMyLikesMood.text = song.mood
        }
    }
}