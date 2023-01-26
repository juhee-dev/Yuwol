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
import com.yuwol.model.Chart
import com.yuwol.model.SongTemp

class ChartAllFragment : Fragment() {
    lateinit var binding: FragmentChartAllBinding
    private lateinit var chartAdapter: ChartAllAdapter
    private val chartData = mutableListOf<Chart>()
    val TAG = "chart"

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

        binding.tvChartAllHot.setOnClickListener {
            initChartList("hot")
            initChartRecyclerView()
        }
        binding.tvChartAllMelon.setOnClickListener {
            initChartList("melon")
            initChartRecyclerView()
        }
        binding.tvChartAllNew.setOnClickListener {
            initChartList("new")
            initChartRecyclerView()
        }
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

        chartAdapter = ChartAllAdapter(SongListAdapterToList())

        chartAdapter.dataList = chartData

        binding.rvChartAll.adapter = chartAdapter
    }

    private fun initChartList(chartType: String) {
        Log.d("chart", "chartType: "+ chartType)

        chartData.clear()

        when (chartType) {
            "hot" -> {
                setTitleGradient("송믈리에 차트", binding.tvChartAllTitle)
                binding.tvChartAllHot.setTextColor(ContextCompat.getColor(requireActivity(), R.color.purple_100))
                binding.tvChartAllMelon.setTextColor(ContextCompat.getColor(requireActivity(), R.color.gray_150))
                binding.tvChartAllNew.setTextColor(ContextCompat.getColor(requireActivity(), R.color.gray_150))
                initHotChartList()
            }
            "melon" -> {
                setTitleGradient("Top 100", binding.tvChartAllTitle)
                binding.tvChartAllHot.setTextColor(ContextCompat.getColor(requireActivity(), R.color.gray_150))
                binding.tvChartAllMelon.setTextColor(ContextCompat.getColor(requireActivity(), R.color.purple_100))
                binding.tvChartAllNew.setTextColor(ContextCompat.getColor(requireActivity(), R.color.gray_150))
                initMelonChartList()
            }
            "new" -> {
                setTitleGradient("최신 음악", binding.tvChartAllTitle)
                binding.tvChartAllHot.setTextColor(ContextCompat.getColor(requireActivity(), R.color.gray_150))
                binding.tvChartAllMelon.setTextColor(ContextCompat.getColor(requireActivity(), R.color.gray_150))
                binding.tvChartAllNew.setTextColor(ContextCompat.getColor(requireActivity(), R.color.purple_100))
                initNewChartList()
            }
            else -> {
                Log.d("chart", "initChartList 오류: intent 값이 없음")
            }
        }
    }

    private fun songTransaction(song: Chart) {
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
        fun getSong(song: Chart) {
            songTransaction(song)
        }
    }

    private fun initHotChartList() {
        var rank = 1
        chartData.addAll(
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
                    R.drawable.cover_omg,
                    rank++.toString(),
                    "Ditto", "NewJeans",
                    "3", "싸해짐", "2", "2", "1"
                ), Chart(
                    R.drawable.cover_firstlove,
                    rank++.toString(),
                    "첫사랑",
                    "백아",
                    "5", "찢음", "5","2","1"
                ), Chart(
                    R.drawable.cover_like,
                    rank++.toString(),
                    "좋니",
                    "윤종신",
                    "2", "보통", "1", "2", "1"
                ), Chart(
                    R.drawable.cover_everytime,
                    rank++.toString(),
                    "너의모든순간(별에서온그대OST)",
                    "성시경",
                    "2", "보통", "2", "2", "1"
                ), Chart(
                    R.drawable.cover_anywhere,
                    rank++.toString(),
                    "어디에도",
                    "MC THE MAX",
                    "4", "싸해짐", "1","2","4"
                ), Chart(
                    R.drawable.cover_doit,
                    rank++.toString(),
                    "해요(2022)",
                    "#안녕",
                    "2", "찢음", "2", "1", "2"
                ), Chart(
                    R.drawable.cover_antifragile,
                    rank++.toString(),
                    "ANTIFRAGILE",
                    "LE SSERAFIM(르세라핌)",
                    "3", "싸해짐", "2", "2", "1"
                )
            )
        )
    }

    private fun initMelonChartList() {
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
                ), Chart(
                    R.drawable.cover_hero,
                    rank++.toString(),
                    "다시 만날 수 있을까",
                    "LE SSERAFIM (르세라핌)",
                    "2", "보통", "1", "2", "1"
                ), Chart(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "London Boy",
                    "임영웅",
                    "2", "보통", "2", "2", "1"
                ), Chart(
                    R.drawable.cover_hero2,
                    rank++.toString(),
                    "Polaroid",
                    "임영웅",
                    "4", "싸해짐", "1","2","4"
                ), Chart(
                    R.drawable.cover_candy,
                    rank++.toString(),
                    "Candy",
                    "NCT DREAM",
                    "2", "찢음", "2", "1", "2"
                ), Chart(
                    R.drawable.cover_hero,
                    rank++.toString(),
                    "무지개",
                    "임영웅",
                    "3", "싸해짐", "2", "2", "1"
                )
            )
        )
    }

    private fun initNewChartList() {
        var rank = 1
        chartData.addAll(
            listOf<Chart>(
                Chart(
                    R.drawable.cover_shoutout,
                    rank++.toString(),
                    "SHOUT OUT", "ENHYPEN",
                    "5", "찢음", "5","2","1"
                ), Chart(
                    R.drawable.cover_imfine,
                    rank++.toString(),
                    "비로소 괜찮아질 거야", "PATEKO (파테코), Jayci yucca (제이씨 유카), Kid Wine",
                    "2", "보통", "1", "2", "1"
                ), Chart(
                    R.drawable.cover_imfine,
                    rank++.toString(),
                    "힘든 거 알아", "PATEKO (파테코), Jayci yucca (제이씨 유카), Kid Wine",
                    "2", "보통", "2", "2", "1"
                ), Chart(
                    R.drawable.cover_quit,
                    rank++.toString(),
                    "퇴사", "Anonymous Artists(어나니머스 아티스트)",
                    "4", "싸해짐", "1","2","4"
                ), Chart(
                    R.drawable.cover_mrtrot,
                    rank++.toString(),
                    "님이여", "황민호", "미스터트롯2 예선 베스트 PART2",
                    "2", "찢음", "2", "1"
                ), Chart(
                    R.drawable.cover_bluecheck,
                    rank++.toString(),
                    "BLUE CHECK REMIX",
                    "박재범, Slom",
                    "5", "찢음", "5","2","1"
                ), Chart(
                    R.drawable.cover_yournum,
                    rank++.toString(),
                    "니 번호가 뜨는 일",
                    "이예준",
                    "2", "보통", "1", "2", "1"
                ), Chart(
                    R.drawable.cover_lastlove,
                    rank++.toString(),
                    "마지막사랑",
                    "신예영",
                    "4", "싸해짐", "1","2","4"
                ), Chart(
                    R.drawable.cover_weagain,
                    rank++.toString(),
                    "우린 다시",
                    "정동원",
                    "2", "보통", "2", "2", "1"
                ), Chart(
                    R.drawable.cover_wishlist,
                    rank++.toString(),
                    "wishlist",
                    "Alaina Castillo",
                    "2", "찢음", "2", "1", "2"
                ), Chart(
                    R.drawable.cover_jp,
                    rank++.toString(),
                    "ビバハピ",
                    "Mitchie M(Feat.初音ミク)",
                    "3", "싸해짐", "2", "2", "1"
                ), Chart(
                    R.drawable.cover_flyer,
                    rank++.toString(),
                    "Flyer!",
                    "Chinozo",
                    "3", "싸해짐", "2", "2", "1"
                )

            )
        )
    }


}