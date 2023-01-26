package com.yuwol.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yuwol.R
import com.yuwol.databinding.ItemCommentBinding
import com.yuwol.model.Comment

class CommentAdapter : RecyclerView.Adapter<CommentAdapter.ViewHolder>(), OnClickListener {

    var dataList = mutableListOf<Comment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCommentBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolder(private val binding: ItemCommentBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(comment: Comment){
            binding.ivItemCommentProfile.setImageResource(R.drawable.cover_newjeans)
            binding.tvItemCommentName.text = "test"
            binding.tvItemComment.text = "testtesttesttesttesttesttest"
            binding.tvItemCommentDate.text = "22.00.00"
            binding.tvItemCommentGood.text = "00"
            binding.tvItemCommentBad.text = "00"
        }
    }

    override fun onClick(v: View?) {
        when {

        }
    }
}