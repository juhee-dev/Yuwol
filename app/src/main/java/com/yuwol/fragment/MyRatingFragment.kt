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
import com.yuwol.LinearGradientSpan
import com.yuwol.R
import com.yuwol.databinding.FragmentMyLikesBinding
import com.yuwol.databinding.FragmentMyRatingBinding

class MyRatingFragment : Fragment() {
    lateinit var binding: FragmentMyRatingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyRatingBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitleGradient("나의 평가", binding.tvChartAllTitle)
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