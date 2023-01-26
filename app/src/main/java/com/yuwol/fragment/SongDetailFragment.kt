package com.yuwol.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.set
import androidx.core.text.toSpannable
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuwol.LinearGradientSpan
import com.yuwol.R
import com.yuwol.adapter.CommentAdapter
import com.yuwol.adapter.CommentBestAdapter
import com.yuwol.databinding.FragmentSongDetailBinding
import com.yuwol.model.Comment
import com.yuwol.model.SongTemp

class SongDetailFragment : Fragment() {
    lateinit var binding: FragmentSongDetailBinding
    lateinit var song: SongTemp
    private lateinit var commentAdapter: CommentAdapter
    private lateinit var commentBestAdapter: CommentBestAdapter
    private val commentData = mutableListOf<Comment>()
    private val bestCommentData = mutableListOf<Comment>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            song = it.getSerializable("song") as SongTemp
        }

        setTitleGradient(binding.tvSongDetailRating.text.toString(), binding.tvSongDetailRating)

        initCommentList()
        initCommentRecyclerView()

        binding.tvSongDetailTitle.text = song.title
        binding.tvSongDetailArtist.text = song.artist
        binding.tvSongDetailAlbum.text = song.album
        binding.tvSongDetailDate.text = song.date

        binding.ivSongDetailBack.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_main, HomeFragment()).commit()
        }

        binding.tvSongDetailMore.setOnClickListener {
            if (binding.clSongDetailMore.visibility == View.VISIBLE) {
                binding.clSongDetailMore.visibility = View.GONE
                binding.clSongDetailMore.animate()
                binding.tvSongDetailMore.text = "상세 평가 더보기"
            } else {
                binding.clSongDetailMore.visibility = View.VISIBLE
                binding.clSongDetailMore.animate()
                binding.tvSongDetailMore.text = "상세 평가 숨기기"
            }
        }
    }

    private fun setTitleGradient(text: String, tv: TextView) {
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, ContextCompat.getColor(requireContext(), R.color.pink_100), ContextCompat.getColor(requireContext(), R.color.purple_100))
        tv.text = spannable
    }

    private fun initCommentRecyclerView() {
        binding.rvSongDetailCommentBest.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvSongDetailComment.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        commentBestAdapter = CommentBestAdapter()
        commentAdapter = CommentAdapter()

        commentBestAdapter.dataList = bestCommentData
        commentAdapter.dataList = commentData
        Log.d("detail", "count of comment data: ${commentData.size}")

        binding.rvSongDetailComment.adapter = commentAdapter
    }

    private fun initCommentList() {
        var id: Long = 0
        bestCommentData.addAll(
            listOf<Comment>(
                Comment(
                    id++, id++, id++, id++
                ), Comment(
                    id++, id++, id++, id++
                ), Comment(
                    id++, id++, id++, id++
                )
            )
        )
        commentData.addAll(
            listOf<Comment>(
                Comment(
                    id++, id++, id++, id++
                ), Comment(
                    id++, id++, id++, id++
                ), Comment(
                    id++, id++, id++, id++
                ), Comment(
                    id++, id++, id++, id++
                ), Comment(
                    id++, id++, id++, id++
                ), Comment(
                    id++, id++, id++, id++
                )
            )
        )
    }
}