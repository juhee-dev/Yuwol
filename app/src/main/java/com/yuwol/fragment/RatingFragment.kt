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

        initRatingList()
        initRatingRecyclerView()
    }

    private fun initRatingRecyclerView() {
        binding.rating.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rateAdapter = RateAdapter(RatingAdapterToList())
        rateAdapter.dataList = rateData
        binding.rating.adapter = rateAdapter
    }

    private fun initRatingList() {
        var rank = 1
        rateData.addAll(
            listOf<Rate>(
                Rate(
                    R.drawable.cover3,
                    rank++.toString(),
                    "BORN PINK",
                    "BLACKPINK"

                ), Rate(
                    R.drawable.cover_endtheory,
                    rank++.toString(),
                    "사건의 지평선",
                    "윤하"
                ), Rate(
                    R.drawable.cover_omg,
                    rank++.toString(),
                    "Ditto", "NewJeans"

                ), Rate(
                    R.drawable.cover_like,
                    rank++.toString(),
                    "좋니",
                    "윤종신"

                ), Rate(
                    R.drawable.cover_antifragile,
                    rank++.toString(),
                    "ANTIFRAGILE",
                    "LE SSERAFIM(르세라핌)"

                ), Rate(
                    R.drawable.cover_newjeans,
                    rank++.toString(),
                    "Hype Boy",
                    "NewJeans"

                ), Rate(
                    R.drawable.cover_vibe,
                    rank++.toString(),
                    "VIBE", "태양"
                ), Rate(
                    R.drawable.cover_hero2,
                    rank++.toString(),
                    "Polaroid",
                    "임영웅"

                ), Rate(
                    R.drawable.cover_candy,
                    rank++.toString(),
                    "Candy",
                    "NCT DREAM"

                ), Rate(
                    R.drawable.cover_doit,
                    rank++.toString(),
                    "해요(2022)",
                    "#안녕"
                )

            )
        )
    }

    fun ratingTransaction(rate: Rate) {
        val bundle = Bundle()
        val rateFirstRatingFragment = FirstRatingFragment()
        bundle.putSerializable("rating", rate)
        rateFirstRatingFragment.arguments = bundle
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fl_main, rateFirstRatingFragment)
            addToBackStack(null)
            commit()
        }
    }

    inner class RatingAdapterToList {
        fun getSongId(rate: Rate) {
            ratingTransaction(rate)
        }
    }
}