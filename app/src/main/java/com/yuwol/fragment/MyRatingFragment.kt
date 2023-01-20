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
import com.yuwol.adapter.*
import com.yuwol.databinding.FragmentChartAllBinding
import com.yuwol.databinding.FragmentMyLikesBinding
import com.yuwol.databinding.FragmentMyRatingBinding
import com.yuwol.model.Chart

class MyRatingFragment : Fragment() {
    lateinit var binding: FragmentMyRatingBinding
    private lateinit var myrateAdapter: MyrateAdapter
    private lateinit var mycommentAdapter: MycommentAdapter
    private val chartData = mutableListOf<Chart>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyRatingBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitleGradient("나의 평가", binding.tvMyRateTitle)



        arguments?.let {
            val chartType = it.getString("chartType")
            if (chartType != null) {
                initChartList(chartType)
                initChartRecyclerView()
            }
        }

        binding.tvMyRate.setOnClickListener { initChartList("평가") }
        binding.tvMyComment.setOnClickListener { initChartList("코멘트") }
        binding.ivMyRateBack.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,UserFragment()).commit()
        }
    }

    private fun setTitleGradient(text: String, tv: TextView) {
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, ContextCompat.getColor(requireContext(), R.color.pink_100), ContextCompat.getColor(requireContext(), R.color.purple_100))
        tv.text = spannable
    }



    private fun initChartRecyclerView() {
        binding.rvMyrating.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMyratingComment.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        myrateAdapter = MyrateAdapter()
        mycommentAdapter = MycommentAdapter()

        myrateAdapter.dataList=chartData
        mycommentAdapter.dataList=chartData

        binding.rvMyrating.adapter= myrateAdapter
        binding.rvMyratingComment.adapter= mycommentAdapter

    }

    private fun initChartList(chartType: String) {
        chartData.clear()

        when (chartType) {
            "평가" -> {
                binding.tvMyRateTitle.text = "평가"
                binding.tvMyRate.setTextColor(ContextCompat.getColor(requireActivity(), R.color.purple_100))
                binding.tvMyComment.setTextColor(ContextCompat.getColor(requireActivity(), R.color.white))

            }
            "코멘트" -> {
                binding.tvMyRateTitle.text = "코멘트"
                binding.tvMyRate.setTextColor(ContextCompat.getColor(requireActivity(), R.color.white))
                binding.tvMyComment.setTextColor(ContextCompat.getColor(requireActivity(), R.color.purple_100))
            }

            else -> {
                Log.d("chart", "initChartList 오류: intent 값이 없음")
            }
        }
        Log.d("chart", "chartType: "+ chartType)

        var rank = 1
        chartData.addAll(
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