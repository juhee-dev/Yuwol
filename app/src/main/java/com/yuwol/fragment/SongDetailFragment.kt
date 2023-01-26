package com.yuwol.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuwol.R
import com.yuwol.adapter.CommentAdapter
import com.yuwol.databinding.FragmentSongDetailBinding
import com.yuwol.model.Comment
import com.yuwol.model.SongTemp

class SongDetailFragment : Fragment() {
    lateinit var binding: FragmentSongDetailBinding
    lateinit var song: SongTemp
    private lateinit var commentAdapter: CommentAdapter
    private val commentData = mutableListOf<Comment>()

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

        binding.tvSongDetailTitle.text = song.title
        binding.tvSongDetailArtist.text = song.artist
        binding.tvSongDetailAlbum.text = song.album
        binding.tvSongDetailDate.text = song.date
        binding.cvSongCover.setImageResource(song.cover)


        binding.ivSongDetailBack.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_main, HomeFragment()).commit()
        }

        binding.tvSongDetailMore.setOnClickListener {
            if (binding.clSongDetailMore.visibility == View.VISIBLE) {
                binding.clSongDetailMore.visibility = View.GONE
//                binding.clSongDetailMore.animate().setDuration(200).rotation(180f)
                binding.clSongDetailMore.animate()
                binding.tvSongDetailMore.text = "상세 평가 더보기"
            } else {
                binding.clSongDetailMore.visibility = View.VISIBLE
//                binding.clSongDetailMore.animate().setDuration(200).rotation(0f)
                binding.clSongDetailMore.animate()
                binding.tvSongDetailMore.text = "상세 평가 숨기기"
            }
        }

        initCommentList()
        initCommentRecyclerView()
    }

    private fun initCommentRecyclerView() {
        binding.rvSongDetailComment.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        commentAdapter = CommentAdapter()

        commentAdapter.dataList = commentData
        Log.d("detail", "count of comment data: ${commentData.size}")

        binding.rvSongDetailComment.adapter = commentAdapter
    }

    private fun initCommentList() {
        var id: Long = 0
        commentData.addAll(
            listOf(
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