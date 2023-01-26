package com.yuwol.fragment

import android.os.Bundle
import android.util.Log
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
import com.yuwol.adapter.ChartMelonAdapter
import com.yuwol.adapter.ChartNewAdapter
import com.yuwol.api.MelonChartServiceCreator
import com.yuwol.data.response.ResponseMelonChartData
import com.yuwol.databinding.FragmentHomeBinding
import com.yuwol.model.SongTemp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(), View.OnClickListener {
    lateinit var binding: FragmentHomeBinding
    private lateinit var chartHotAdapter: ChartAdapter
    private lateinit var chartMelonAdapter: ChartMelonAdapter
    private lateinit var chartNewAdapter: ChartNewAdapter
    private val hotChartData = mutableListOf<SongTemp>()
    private val melonChartData = mutableListOf<SongTemp>()
    private val newChartData = mutableListOf<SongTemp>()
    val TAG = "home"

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

//        getChartList()
        initSongmmelierChartList()
        initMelonChartList()
        initNewChartList()
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

        chartHotAdapter = ChartAdapter(SongListAdapterToList())
        chartMelonAdapter = ChartMelonAdapter(SongListAdapterToList())
        chartNewAdapter = ChartNewAdapter(SongListAdapterToList())

        chartHotAdapter.dataList = hotChartData
        chartMelonAdapter.dataList = melonChartData
        chartNewAdapter.dataList = newChartData

        binding.rvChartHot.adapter = chartHotAdapter
        binding.rvChartMelon.adapter = chartMelonAdapter
        binding.rvChartNew.adapter = chartNewAdapter
    }

    private fun getChartList() {
        val token = arguments?.getString("token")
        Log.d(TAG, "get token: $token")
        val call: Call<ResponseMelonChartData> = MelonChartServiceCreator.melonChartService.getMellonChart(token!!)
        call.enqueue(object : Callback<ResponseMelonChartData> {
            override fun onResponse(
                call: Call<ResponseMelonChartData>,
                response: Response<ResponseMelonChartData>
            ) {
                if(response.isSuccessful){
                    Log.d(TAG, "network success")
                    val data = response.body().toString()
                    Log.d(TAG, "onResponse: $data")
                }
            }

            override fun onFailure(call: Call<ResponseMelonChartData>, t: Throwable) {
                Log.e(TAG, "onFailure: ", )
            }
        })
    }

    private fun initSongmmelierChartList() {
        var rank = 1
        hotChartData.addAll(
            listOf<SongTemp>(
                SongTemp(
                    R.drawable.cover_endtheory,
                    rank++.toString(),
                    "사건의 지평선", "윤하", "END THEORY", "2022.03.30",
                    "5", "찢음", "5","2","1",
                    130, 12
                ), SongTemp(
                    R.drawable.cover_monologue,
                    rank++.toString(),
                    "Monologue", "tei", "ANTIFRAGILE", "2022.10.17",
                    "4", "싸해짐", "4", "4", "4",
                    80, 7
                ), SongTemp(
                    R.drawable.cover_newjeans,
                    rank++.toString(),
                    "Hype boy", "NewJeans", "NewJeans", "2022.08.01",
                    "4", "싸해짐", "4","4","4",
                    100, 9
                ), SongTemp(
                    R.drawable.cover_emerge,
                    rank++.toString(),
                    "응급실(쾌걸춘향OST)", "izi", "END THEORY", "2022.03.30",
                    "5", "찢음", "5","2","1",
                    130, 12
                ), SongTemp(
                    R.drawable.cover_notme,
                    rank++.toString(),
                    "내가아니라도", "주호", "ANTIFRAGILE", "2022.10.17",
                    "4", "싸해짐", "4", "4", "4",
                    80, 7
                ), SongTemp(
                    R.drawable.cover_omg,
                    rank++.toString(),
                    "Ditto", "NewJeans", "OMG", "2023.01.02",
                    "4", "싸해짐", "4","4","4",
                    100, 9
                ),
            )
        )
    }

    private fun initMelonChartList() {
        var rank = 1
        melonChartData.addAll(
            listOf<SongTemp>(
                SongTemp(
                    R.drawable.cover_omg,
                    rank++.toString(),
                    "Ditto", "NewJeans", "OMG", "2023.01.02",
                    "5", "찢음", "5","2","1",
                    130, 12
                ), SongTemp(
                    R.drawable.cover_omg,
                    rank++.toString(),
                    "OMG", "NewJeans", "OMG", "2023.01.02",
                    "4", "싸해짐", "4", "4", "4",
                    80, 7
                ), SongTemp(
                    R.drawable.cover_newjeans,
                    rank++.toString(),
                    "Hype Boy", "NewJeans", "NewJeans", "2022.08.01",
                    "4", "싸해짐", "4","4","4",
                    100, 9
                ), SongTemp(
                    R.drawable.cover_endtheory,
                    rank++.toString(),
                    "사건의 지평선", "윤하", "END THEORY", "2022.03.30",
                    "5", "찢음", "5","2","1",
                    130, 12
                ), SongTemp(
                    R.drawable.cover_vibe,
                    rank++.toString(),
                    "VIBE", "태양", "VIBE", "2023.01.13",
                    "4", "싸해짐", "4", "4", "4",
                    80, 7
                ), SongTemp(
                    R.drawable.cover_antifragile,
                    rank++.toString(),
                    "ANTIFRAGILE", "LE SSERAFIM (르세라핌)", "ANTIFRAGILE", "2022.10.17",
                    "4", "싸해짐", "4", "4", "4",
                    80, 7
                ),
            )
        )
    }

    private fun initNewChartList() {
        var rank = 1
        newChartData.addAll(
            listOf<SongTemp>(
                SongTemp(
                    R.drawable.cover_shoutout,
                    rank++.toString(),
                    "SHOUT OUT", "ENHYPEN", "MANIFESTO : DAY 1", "2022.07.04",
                    "4", "싸해짐", "4", "4", "4",
                    80, 7
                ), SongTemp(
                    R.drawable.cover_imfine,
                    rank++.toString(),
                    "비로소 괜찮아질 거야", "PATEKO (파테코), Jayci yucca (제이씨 유카), Kid Wine", "어서와요 키카코 하우스 2", "2022.12.29",
                    "4", "싸해짐", "4","4","4",
                    100, 9
                ), SongTemp(
                    R.drawable.cover_imfine,
                    rank++.toString(),
                    "힘든 거 알아", "PATEKO (파테코), Jayci yucca (제이씨 유카), Kid Wine", "어서와요 키카코 하우스 2", "2022.12.29",
                    "5", "찢음", "5","2","1",
                    130, 12
                ), SongTemp(
                    R.drawable.cover_quit,
                    rank++.toString(),
                    "퇴사", "Anonymous Artists(어나니머스 아티스트)", "ARTISI 이민석", "2020.07.30",
                    "4", "싸해짐", "4", "4", "4",
                    80, 7
                ), SongTemp(
                    R.drawable.cover_mrtrot,
                    rank++.toString(),
                    "님이여", "황민호", "미스터트롯2 예선 베스트 PART2", "2022.12.30",
                    "4", "싸해짐", "4","4","4",
                    100, 9
                ),
                SongTemp(
                    R.drawable.cover_bluecheck,
                    rank++.toString(),
                    "BLUE CHECK REMIX", "박재범, Slom", "SLAY HOUSE REMIX", "2023.01.17",
                    "4", "싸해짐", "4","4","4",
                    100, 9
                )
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

    private fun songTransaction(song: SongTemp) {
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
        fun getSong(song: SongTemp) {
            songTransaction(song)
        }
    }
}