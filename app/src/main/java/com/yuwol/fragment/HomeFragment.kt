package com.yuwol.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuwol.R
import com.yuwol.adapter.ChartAdapter
import com.yuwol.databinding.FragmentHomeBinding
import com.yuwol.model.Chart

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private lateinit var chartAdapter: ChartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("fragment", "HomeFragment")

        binding.rvChartHot.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvChartMelon.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvChartNew.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        // 우리가 사용할 어댑터의 초기값을 넣어줌
        chartAdapter = ChartAdapter()
        // RecyclerView에 어뎁터를 우리가 만든 어뎁터로!
        binding.rvChartHot.adapter = chartAdapter
        binding.rvChartMelon.adapter = chartAdapter
        binding.rvChartNew.adapter = chartAdapter

        // 데이터 넣기
        chartAdapter.chartList.addAll(
            listOf<Chart>(
                Chart(
                    R.drawable.cover,
                    "Nxde",
                    "(여자)아이들",
                    "4","1","2","4"
                ), Chart(
                    R.drawable.cover,
                    "ANTIFRAGILE",
                    "LE SSERAFIM (르세라핌)",
                    "2", "1", "2", "1"
                ), Chart(
                    R.drawable.cover,
                    "Hype Boy",
                    "NewJeans",
                    "2", "2", "2", "1"
                ), Chart(
                    R.drawable.cover,
                    "Nxde",
                    "(여자)아이들",
                    "4","1","2","4"
                ), Chart(
                    R.drawable.cover,
                    "ANTIFRAGILE",
                    "LE SSERAFIM (르세라핌)",
                    "2", "1", "2", "1"
                ), Chart(
                    R.drawable.cover,
                    "Hype Boy",
                    "NewJeans",
                    "2", "2", "2", "1"
                )
            )
        )
        chartAdapter.notifyDataSetChanged()
    }
}