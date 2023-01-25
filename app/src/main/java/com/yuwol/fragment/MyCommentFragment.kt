package com.yuwol.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.set
import androidx.core.text.toSpannable
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuwol.LinearGradientSpan
import com.yuwol.R
import com.yuwol.adapter.MycommentAdapter
import com.yuwol.adapter.MyrateAdapter
import com.yuwol.databinding.FragmentMyCommentBinding
import com.yuwol.model.Chart

class MyCommentFragment : Fragment() {
    lateinit var binding: FragmentMyCommentBinding
    private lateinit var mycommentAdapter: MycommentAdapter
    private val commentData = mutableListOf<Chart>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyCommentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initCommentList()
        initCommentRecyclerView()

        binding.tvMyRate.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_main, MyRatingFragment()).commit()
        }

        binding.ivMyCommentBack.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,UserFragment()).commit()
        }
    }

    private fun initCommentRecyclerView() {
        binding.rvMyrating.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        mycommentAdapter = MycommentAdapter()
        mycommentAdapter.dataList = commentData

        binding.rvMyrating.adapter = mycommentAdapter
    }

    private fun initCommentList() {
        commentData.clear()

        var rank = 1
        commentData.addAll(
            listOf<Chart>(
                Chart(
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