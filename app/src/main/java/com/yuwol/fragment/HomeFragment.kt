package com.yuwol.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.set
import androidx.core.text.toSpannable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuwol.LinearGradientSpan
import com.yuwol.R
import com.yuwol.adapter.ChartAdapter
import com.yuwol.databinding.FragmentHomeBinding
import com.yuwol.model.Chart
import com.yuwol.model.Song

class HomeFragment : Fragment(), View.OnClickListener {
    lateinit var binding: FragmentHomeBinding
    private lateinit var chartAdapter: ChartAdapter
    private val chartData = mutableListOf<Song>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitleGradient(getString(R.string.chart_title_smlr), binding.textView2)
        setTitleGradient(getString(R.string.chart_title_melon), binding.textView3)
        setTitleGradient(getString(R.string.chart_title_new), binding.textView4)

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

    private fun setTitleGradient(text: String, tv: TextView) {
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, ContextCompat.getColor(requireContext(), R.color.pink_100), ContextCompat.getColor(requireContext(), R.color.purple_100))
        tv.text = spannable
    }

    private fun initChartRecyclerView() {
        binding.rvChartHot.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvChartMelon.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvChartNew.layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.HORIZONTAL, false)

        chartAdapter = ChartAdapter(SongListAdapterToList())

        chartAdapter.dataList = chartData

        binding.rvChartHot.adapter = chartAdapter
        binding.rvChartMelon.adapter = chartAdapter
        binding.rvChartNew.adapter = chartAdapter
    }

    private fun initChartList() {
        var rank = 1
        chartData.addAll(
            listOf<Song>(
                Song(
                    R.drawable.cover2,
                    rank++.toString(),
                    "사건의 지평선", "윤하", "END THEORY", "2022.03.30",
                    "5", "찢음", "5","2","1",
                    130, 12
                ), Song(
                    R.drawable.cover1,
                    rank++.toString(),
                    "ANTIFRAGILE", "LE SSERAFIM (르세라핌)", "ANTIFRAGILE", "2022.10.17",
                    "4", "싸해짐", "4", "4", "4",
                    80, 7
                ), Song(
                    R.drawable.cover3,
                    rank++.toString(),
                    "Shut Down", "BLACKPINK", "BORN PINK", "2022.09.16",
                    "4", "싸해짐", "4","4","4",
                    100, 9
                ), Song(
                    R.drawable.cover2,
                    rank++.toString(),
                    "사건의 지평선", "윤하", "END THEORY", "2022.03.30",
                    "5", "찢음", "5","2","1",
                    130, 12
                ), Song(
                    R.drawable.cover1,
                    rank++.toString(),
                    "ANTIFRAGILE", "LE SSERAFIM (르세라핌)", "ANTIFRAGILE", "2022.10.17",
                    "4", "싸해짐", "4", "4", "4",
                    80, 7
                ), Song(
                    R.drawable.cover3,
                    rank++.toString(),
                    "Shut Down", "BLACKPINK", "BORN PINK", "2022.09.16",
                    "4", "싸해짐", "4","4","4",
                    100, 9
                ),
            )
        )
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

    private fun songTransaction(song: Song) {
        val bundle = Bundle()
        val songDetailFragment = SongDetailFragment()
        bundle.putSerializable("song", song)
        songDetailFragment.arguments = bundle
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fl_main, songDetailFragment)
            addToBackStack(null)
            commit()
        }
    }

    inner class SongListAdapterToList {
        fun getSong(song: Song) {
            songTransaction(song)
        }
    }
}