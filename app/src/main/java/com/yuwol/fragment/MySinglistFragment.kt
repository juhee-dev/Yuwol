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
import com.yuwol.adapter.MysinglistAdapter
import com.yuwol.databinding.FragmentMyLikesBinding
import com.yuwol.databinding.FragmentMySinglistBinding
import com.yuwol.model.Chart

class MySinglistFragment : Fragment() {
    lateinit var binding: FragmentMySinglistBinding
    private lateinit var mysinglistAdapter: MysinglistAdapter
    private val chartData = mutableListOf<Chart>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMySinglistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initChartList()
        initChartRecyclerView()

        binding.ivMySinglistBack.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,UserFragment()).commit()
        }
    }

    private fun initChartRecyclerView() {
        binding.rvMySinglist.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mysinglistAdapter = MysinglistAdapter()
        mysinglistAdapter.dataList = chartData
        binding.rvMySinglist.adapter = mysinglistAdapter
    }
    private fun initChartList() {
        chartData.clear()

        // when 필요한가...

        Log.d("chart", "chartType: ")

        var rank = 1
        chartData.addAll(
            listOf<Chart>(
                Chart(
                    R.drawable.cover_omg,
                    rank++.toString(),
                    "Ditto", "NewJeans",
                    "5", "찢음", "5","2","1"
                ), Chart(
                    R.drawable.cover_omg,
                    rank++.toString(),
                    "OMG", "NewJeans",
                    "2", "보통", "1", "2", "1"
                ),Chart(
                    R.drawable.cover_newjeans,
                    rank++.toString(),
                    "Hype Boy",
                    "NewJeans",
                    "4", "싸해짐", "1","2","4"
                ), Chart(
                    R.drawable.cover_endtheory,
                    rank++.toString(),
                    "사건의 지평선", "윤하",
                    "2", "보통", "2", "2", "1"
                ), Chart(
                    R.drawable.cover_vibe,
                    rank++.toString(),
                    "VIBE", "태양",
                    "4", "싸해짐", "1","2","4"
                ), Chart(
                    R.drawable.cover_antifragile,
                    rank++.toString(),
                    "ANTIFRAGILE", "LE SSERAFIM (르세라핌)",
                    "2", "찢음", "2", "1", "2"
                ), Chart(
                    R.drawable.cover_loverun,
                    rank++.toString(),
                    "사랑은 늘 도망가",
                    "임영웅",
                    "3", "싸해짐", "2", "2", "1"
                ), Chart(
                    R.drawable.cover_hero,
                    rank++.toString(),
                    "우리들의 블루스",
                    "윤하",
                    "5", "찢음", "5","2","1"
                )
            )
        )
    }
}