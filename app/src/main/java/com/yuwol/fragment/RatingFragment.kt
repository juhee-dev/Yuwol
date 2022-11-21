package com.yuwol.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuwol.R
import com.yuwol.adapter.RateAdapter
import com.yuwol.databinding.FragmentRatingBinding
import com.yuwol.model.Rate

class RatingFragment : Fragment() {

    lateinit var binding: FragmentRatingBinding
    private lateinit var rateAdapter: RateAdapter
    private val rateData = mutableListOf<Rate>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRatingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRateList()
        initRateRecyclerView()
    }

    private fun initRateRecyclerView() {
        binding.rating.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rateAdapter = RateAdapter()
        rateAdapter.dataList = rateData
        binding.rating.adapter = rateAdapter
    }

    private fun initRateList() {
        var rank = 1
        rateData.addAll(
            listOf<Rate>(
                Rate(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "Nxde",
                    "(여자)아이들"

                ), Rate(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "ANTIFRAGILE",
                    "LE SSERAFIM (르세라핌)"
                ), Rate(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "Hype Boy",
                    "NewJeans"

                ), Rate(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "Nxde",
                    "(여자)아이들"

                ), Rate(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "ANTIFRAGILE",
                    "LE SSERAFIM (르세라핌)"

                ), Rate(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "Hype Boy",
                    "NewJeans"

                ), Rate(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "Nxde",
                    "(여자)아이들"
                ), Rate(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "ANTIFRAGILE",
                    "LE SSERAFIM (르세라핌)"

                ), Rate(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "Nxde",
                    "(여자)아이들"

                ), Rate(
                    R.drawable.cover_note,
                    rank++.toString(),
                    "사건의 지평선",
                    "윤하"
                )

            )
        )
    }
}