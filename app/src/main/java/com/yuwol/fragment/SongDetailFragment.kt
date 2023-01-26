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

//        initCommentList()
//        initCommentRecyclerView()

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

//    private fun initCommentRecyclerView() {
//        binding.rvSongDetailCommentBest.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
//        binding.rvSongDetailComment.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
//
//        commentBestAdapter = CommentBestAdapter()
//        commentAdapter = CommentAdapter()
//
//        commentBestAdapter.dataList = bestCommentData
//        commentAdapter.dataList = commentData
//        Log.d("detail", "count of comment data: ${commentData.size}")
//
//        binding.rvSongDetailComment.adapter = commentAdapter
//    }
//
//    private fun initCommentList() {
//        bestCommentData.addAll(
//            listOf<Comment>(
//                Comment(
//                    R.drawable.profile_default.toString(),
//                    "유월월월",
//                    "제가 한 마디 하겠습니다 이거 진짜 분위기 찢음",
//                    "22.12.25",
//                    15, 0
//                ), Comment(
//                    R.drawable.profile_default.toString(),
//                    "유컹컹컹",
//                    "제가 두 마디 하겠습니다 이거 분위기 찢고 가창 개오짐",
//                    "22.12.26",
//                    13, 0
//                ),Comment(
//                    R.drawable.profile_default.toString(),
//                    "유왈왈왈",
//                    "제가 세 마디 하겠습니다 이거 분위기 찢고 가창 개오지고 저음도 오짐",
//                    "22.12.26",
//                    10, 0
//                ),
//            )
//        )
//    }
}