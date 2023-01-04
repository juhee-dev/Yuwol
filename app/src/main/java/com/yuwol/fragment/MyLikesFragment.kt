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
import com.yuwol.databinding.FragmentMyLikesBinding
import com.yuwol.model.Chart


class MyLikesFragment : Fragment() {
    lateinit var binding: FragmentMyLikesBinding
    private lateinit var chartAdapter: ChartAllAdapter
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

        setTitleGradient("나의 관심", binding.tvChartAllTitle)

        binding.ivChartAllBack.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,UserFragment()).commit()
        }


    }

    private fun setTitleGradient(text: String, tv: TextView) {
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, ContextCompat.getColor(requireContext(), R.color.pink_100), ContextCompat.getColor(requireContext(), R.color.purple_100))
        tv.text = spannable
    }




}