package com.yuwol.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuwol.R
import com.yuwol.adapter.RateAdapter
import com.yuwol.databinding.FragmentHomeBinding
import com.yuwol.databinding.FragmentRatingBinding
import com.yuwol.model.Rate


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RatingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RatingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating, container, false)
    }*/


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RatingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RatingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    lateinit var binding: FragmentRatingBinding
    private lateinit var RateAdapter: RateAdapter
    private val RateData = mutableListOf<Rate>()

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

        RateAdapter = RateAdapter()

        RateAdapter.dataList = RateData

        binding.rating.adapter = RateAdapter

    }



    private fun initRateList() {
        var rank = 1
        RateData.addAll(
            listOf<Rate>(
                Rate(
                    R.drawable.cover,
                    rank++.toString(),
                    "Nxde",
                    "(여자)아이들"

                ), Rate(
                    R.drawable.cover,
                    rank++.toString(),
                    "ANTIFRAGILE",
                    "LE SSERAFIM (르세라핌)"
                ), Rate(
                    R.drawable.cover,
                    rank++.toString(),
                    "Hype Boy",
                    "NewJeans"

                ), Rate(
                    R.drawable.cover,
                    rank++.toString(),
                    "Nxde",
                    "(여자)아이들"

                ), Rate(
                    R.drawable.cover,
                    rank++.toString(),
                    "ANTIFRAGILE",
                    "LE SSERAFIM (르세라핌)"

                ), Rate(
                    R.drawable.cover,
                    rank++.toString(),
                    "다른 오류가 떠..^^",
                    "NewJeans"

                ), Rate(
                    R.drawable.cover,
                    rank++.toString(),
                    "다른 오류가 떠..^^",
                    "NewJeans"
                ), Rate(
                    R.drawable.cover,
                    rank++.toString(),
                    "다른 오류가 떠..^^",
                    "NewJeans"

                ), Rate(
                    R.drawable.cover,
                    rank++.toString(),
                    "다른 오류가 떠..^^",
                    "NewJeans"

                ), Rate(
                    R.drawable.cover,
                    rank++.toString(),
                    "다른 오류가 떠..^^",
                    "NewJeans"

                )

            )
        )
    }
}