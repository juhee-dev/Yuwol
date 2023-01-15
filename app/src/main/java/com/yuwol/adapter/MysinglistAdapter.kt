package com.yuwol.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yuwol.databinding.ItemMySinglistBinding
import com.yuwol.fragment.MySinglistFragment
import com.yuwol.model.Chart
import com.yuwol.model.Song

class MysinglistAdapter : RecyclerView.Adapter<MysinglistAdapter.ViewHolder>() {
    var dataList = mutableListOf<Chart>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMySinglistBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataList[position])

    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolder(private val binding: ItemMySinglistBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(song: Chart){
            binding.ivItemMySinglistCover.setImageResource(song.cover)
            binding.tvItemMySinglistTitle.text = song.title
            binding.tvItemMySinglistArtist.text = song.artist
            binding.tvItemMySinglistDifficulty.text = song.difficulty
            binding.tvMySinglistMood.text = song.mood
        }
    }

}