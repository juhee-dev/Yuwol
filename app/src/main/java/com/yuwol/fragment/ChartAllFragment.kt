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
import com.yuwol.adapter.ChartAllAdapter
import com.yuwol.databinding.FragmentChartAllBinding
import com.yuwol.databinding.FragmentHomeBinding
import com.yuwol.model.Chart

class ChartAllFragment : Fragment() {
//내거 적용이 되나?
    lateinit var binding: FragmentChartAllBinding
    private lateinit var chartAdapter: ChartAllAdapter
    private val chartData = mutableListOf<Chart>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChartAllBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val chartType = it.getString("chartType")
            if (chartType != null) {
                initChartList(chartType)
                initChartRecyclerView()
            }
        }

        binding.tvChartAllHot.setOnClickListener { initChartList("hot") }
        binding.tvChartAllMelon.setOnClickListener { initChartList("melon") }
        binding.tvChartAllNew.setOnClickListener { initChartList("new") }
        binding.ivChartAllBack.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_main, HomeFragment()).commit()
        }
    }

    private fun setTitleGradient(text: String, tv: TextView) {
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, ContextCompat.getColor(requireContext(), R.color.pink_300), ContextCompat.getColor(requireContext(), R.color.purple_300))
        tv.text = spannable
    }

    private fun initChartRecyclerView() {
        binding.rvChartAll.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        chartAdapter = ChartAllAdapter()
        chartAdapter.dataList = chartData
        binding.rvChartAll.adapter = chartAdapter
    }

    private fun initChartList(chartType: String) {
        chartData.clear()

        when (chartType) {
            "hot" -> {
                setTitleGradient("송믈리에 차트", binding.tvChartAllTitle)
                binding.tvChartAllHot.setTextColor(ContextCompat.getColor(requireActivity(), R.color.purple_100))
                binding.tvChartAllMelon.setTextColor(ContextCompat.getColor(requireActivity(), R.color.gray_150))
                binding.tvChartAllNew.setTextColor(ContextCompat.getColor(requireActivity(), R.color.gray_150))
            }
            "melon" -> {
                setTitleGradient("Top 100", binding.tvChartAllTitle)
                binding.tvChartAllHot.setTextColor(ContextCompat.getColor(requireActivity(), R.color.gray_150))
                binding.tvChartAllMelon.setTextColor(ContextCompat.getColor(requireActivity(), R.color.purple_100))
                binding.tvChartAllNew.setTextColor(ContextCompat.getColor(requireActivity(), R.color.gray_150))
            }
            "new" -> {
                setTitleGradient("최신 음악", binding.tvChartAllTitle)
                binding.tvChartAllHot.setTextColor(ContextCompat.getColor(requireActivity(), R.color.gray_150))
                binding.tvChartAllMelon.setTextColor(ContextCompat.getColor(requireActivity(), R.color.gray_150))
                binding.tvChartAllNew.setTextColor(ContextCompat.getColor(requireActivity(), R.color.purple_100))
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