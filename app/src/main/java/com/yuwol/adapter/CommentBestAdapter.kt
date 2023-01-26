package com.yuwol.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yuwol.R
import com.yuwol.databinding.ItemCommentBestBinding
import com.yuwol.databinding.ItemCommentBinding
import com.yuwol.model.Comment

class CommentBestAdapter : RecyclerView.Adapter<CommentBestAdapter.ViewHolder>(), OnClickListener {

    var dataList = mutableListOf<Comment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCommentBestBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolder(private val binding: ItemCommentBestBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(comment: Comment){
            binding.ivItemCommentProfile.setImageResource(R.drawable.cover_note)
            binding.tvItemCommentName.text = comment.name
            binding.tvItemComment.text = comment.comment
            binding.tvItemCommentDate.text = comment.date
            binding.tvItemCommentGood.text = comment.like.toString()
            binding.tvItemCommentBad.text = comment.dislike.toString()
        }
    }

    override fun onClick(v: View?) {
        when {

        }
    }
}