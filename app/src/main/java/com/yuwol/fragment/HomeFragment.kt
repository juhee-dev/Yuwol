package com.yuwol.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuwol.R
import com.yuwol.adapter.ChartAdapter
import com.yuwol.databinding.FragmentHomeBinding
import com.yuwol.model.Chart

class HomeFragment : Fragment(), View.OnClickListener {
    lateinit var binding: FragmentHomeBinding
    private lateinit var chartAdapter: ChartAdapter
    private val chartData = mutableListOf<Chart>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initChartList()
        initChartRecyclerView()

        binding.tvHomeAll.setOnClickListener(this)
        binding.tvHomeAllMelon.setOnClickListener(this)
        binding.tvHomeAllNew.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_home_all -> {
                chartTransaction("hot")
            }
            R.id.tv_home_all_melon -> {
                chartTransaction("melon")
            }
            R.id.tv_home_all_new -> {
                chartTransaction("new")
            }
        }
    }

    private fun chartTransaction(chartType: String) {
        val bundle = Bundle()
        val chartAllFragment = ChartAllFragment()
        bundle.putString("chartType", chartType)
        chartAllFragment.arguments = bundle
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fl_main, chartAllFragment)
            addToBackStack(null)
            commit()
        }
    }

    private fun initChartRecyclerView() {
        binding.rvChartHot.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvChartMelon.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvChartNew.layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.HORIZONTAL, false)

        chartAdapter = ChartAdapter()

        chartAdapter.dataList = chartData

        binding.rvChartHot.adapter = chartAdapter
        binding.rvChartMelon.adapter = chartAdapter
        binding.rvChartNew.adapter = chartAdapter
    }

    private fun initChartList() {
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
                )
            )
        )
    }
}