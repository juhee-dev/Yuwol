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
                    R.drawable.cover_note,
                    rank++.toString(),
                    "사건의 지평선",
                    "윤하",
                    "5", "찢음", "5","2","1"
                ), Chart(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "ANTIFRAGILE",
                    "LE SSERAFIM (르세라핌)",
                    "2", "보통", "1", "2", "1"
                ), Chart(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "Hype Boy",
                    "NewJeans",
                    "2", "보통", "2", "2", "1"
                ), Chart(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "Nxde",
                    "(여자)아이들",
                    "4", "싸해짐", "1","2","4"
                ), Chart(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "After Like",
                    "IVE (아이브)",
                    "2", "찢음", "2", "1", "2"
                ), Chart(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "Attention",
                    "NewJeans",
                    "3", "싸해짐", "2", "2", "1"
                ), Chart(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "사건의 지평선",
                    "윤하",
                    "5", "찢음", "5","2","1"
                ), Chart(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "ANTIFRAGILE",
                    "LE SSERAFIM (르세라핌)",
                    "2", "보통", "1", "2", "1"
                ), Chart(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "Hype Boy",
                    "NewJeans",
                    "2", "보통", "2", "2", "1"
                ), Chart(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "Nxde",
                    "(여자)아이들",
                    "4", "싸해짐", "1","2","4"
                ), Chart(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "After Like",
                    "IVE (아이브)",
                    "2", "찢음", "2", "1", "2"
                ), Chart(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "Attention",
                    "NewJeans",
                    "3", "싸해짐", "2", "2", "1"
                )
            )
        )
    }

}