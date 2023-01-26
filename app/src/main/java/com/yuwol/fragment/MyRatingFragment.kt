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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuwol.LinearGradientSpan
import com.yuwol.R
import com.yuwol.adapter.*
import com.yuwol.databinding.FragmentMyRatingBinding
import com.yuwol.model.Chart

class MyRatingFragment : Fragment() {
    lateinit var binding: FragmentMyRatingBinding
    private lateinit var myrateAdapter: MyrateAdapter
    private val ratingData = mutableListOf<Chart>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyRatingBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRatingList()
        initRatingRecyclerView()

        binding.tvMyComment.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_main, MyCommentFragment()).commit()
        }

        binding.ivMyRateBack.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,UserFragment()).commit()
        }
    }

    private fun initRatingRecyclerView() {
        binding.rvMyrating.layoutManager = GridLayoutManager(activity, 3)

        myrateAdapter = MyrateAdapter()
        myrateAdapter.dataList = ratingData

        binding.rvMyrating.adapter = myrateAdapter
    }

    private fun initRatingList() {
        ratingData.clear()

        binding.tvMyRateTitle.text = "나의 평가"
        binding.tvMyRate.setTextColor(ContextCompat.getColor(requireActivity(), R.color.purple_100))
        binding.tvMyComment.setTextColor(ContextCompat.getColor(requireActivity(), R.color.white))

        var rank = 1
        ratingData.addAll(
            listOf<Chart>(
                Chart(
                    R.drawable.cover_endtheory,
                    rank++.toString(),
                    "사건의 지평선",
                    "윤하",
                    "5", "찢음", "5","2","1"
                ), Chart(
                    R.drawable.cover_monologue,
                    rank++.toString(),
                    "Monologue", "tei",
                    "2", "보통", "1", "2", "1"
                ), Chart(
                    R.drawable.cover_newjeans,
                    rank++.toString(),
                    "Hype boy", "NewJeans",
                    "2", "보통", "2", "2", "1"
                ), Chart(
                    R.drawable.cover_emerge,
                    rank++.toString(),
                    "응급실(쾌걸춘향OST)", "izi",
                    "4", "싸해짐", "1","2","4"
                ), Chart(
                    R.drawable.cover_notme,
                    rank++.toString(),
                    "내가아니라도", "주호",
                    "2", "찢음", "2", "1", "2"
                ), Chart(
                    R.drawable.cover_firstlove,
                    rank++.toString(),
                    "첫사랑",
                    "백아",
                    "3", "싸해짐", "2", "2", "1"
                ), Chart(
                    R.drawable.cover_everytime,
                    rank++.toString(),
                    "너의모든순간(별에서온그대OST)",
                    "성시경",
                    "5", "찢음", "5","2","1"
                )
            )
        )
    }

}