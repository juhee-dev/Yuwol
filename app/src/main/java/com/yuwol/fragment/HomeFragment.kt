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


class HomeFragment : Fragment() {
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
    }

    private fun initChartRecyclerView() {
        binding.rvChartHot.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvChartMelon.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        //binding.rvChartNew.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val gridLayoutManager = GridLayoutManager(activity, 2, GridLayoutManager.HORIZONTAL, false)
        binding.rvChartNew.setLayoutManager(gridLayoutManager)


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
                    R.drawable.cover,
                    rank++.toString(),
                    "Nxde",
                    "(여자)아이들",
                    "4","1","2","4"
                ), Chart(
                    R.drawable.cover,
                    rank++.toString(),
                    "ANTIFRAGILE",
                    "LE SSERAFIM (르세라핌)",
                    "2", "1", "2", "1"
                ), Chart(
                    R.drawable.cover,
                    rank++.toString(),
                    "Hype Boy",
                    "NewJeans",
                    "2", "2", "2", "1"
                ), Chart(
                    R.drawable.cover,
                    rank++.toString(),
                    "Nxde",
                    "(여자)아이들",
                    "4","1","2","4"
                ), Chart(
                    R.drawable.cover,
                    rank++.toString(),
                    "ANTIFRAGILE",
                    "LE SSERAFIM (르세라핌)",
                    "2", "1", "2", "1"
                ), Chart(
                    R.drawable.cover,
                    rank++.toString(),
                    "이제 오류 안떠!",
                    "NewJeans",
                    "2", "2", "3", "1"
                )
            )
        )
    }
}