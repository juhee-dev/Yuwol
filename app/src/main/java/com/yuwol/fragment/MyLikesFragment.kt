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
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuwol.LinearGradientSpan
import com.yuwol.R
import com.yuwol.adapter.MylikesAdapter
import com.yuwol.databinding.FragmentMyLikesBinding
import com.yuwol.model.Chart
import com.yuwol.model.SongTemp


class MyLikesFragment : Fragment() {
    lateinit var binding: FragmentMyLikesBinding
    private lateinit var mylikesAdapter: MylikesAdapter
    private val chartData = mutableListOf<Chart>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyLikesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitleGradient("나의 관심", binding.tvMyLikesTitle)

        initChartList()
        initChartRecyclerView()

        binding.ivMyLikesBack.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,UserFragment()).commit()
        }
    }

    private fun setTitleGradient(text: String, tv: TextView) {
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, ContextCompat.getColor(requireContext(), R.color.pink_100), ContextCompat.getColor(requireContext(), R.color.purple_100))
        tv.text = spannable
    }

    private fun initChartRecyclerView() {
        binding.rvMyLikesAll.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mylikesAdapter = MylikesAdapter()
        mylikesAdapter.dataList= chartData
        binding.rvMyLikesAll.adapter = mylikesAdapter
    }
    private fun initChartList() {
        chartData.clear()

        // when 필요한가...

        Log.d("chart", "chartType: ")

        var rank = 1
        chartData.addAll(
            listOf<Chart>(
                Chart(
                    R.drawable.cover_endtheory,
                    rank++.toString(),
                    "사건의 지평선",
                    "윤하",
                    "5", "찢음", "5","2","1"
                ),Chart(
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
                )
            )
        )
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

}