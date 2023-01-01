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
import com.yuwol.adapter.RateAdapter
import com.yuwol.databinding.FragmentFirstratingBinding
import com.yuwol.databinding.FragmentUserBinding
import com.yuwol.model.Rate

class UserFragment : Fragment() {
    lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitleGradient("나의\n싱리스트", binding.textView3)
        setTitleGradient("나의\n관심", binding.textView4)
        setTitleGradient("나의\n평가", binding.textView5)
        setTitleGradient("프로필\n수정", binding.textView6)
        setTitleGradient("설정", binding.textView7)



        binding.ivRectangle.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_main, MySinglistFragment())
                .commit()
        }
        binding.ivRectangle2.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_main, MyLikesFragment())
                .commit()
        }
        binding.ivRectangle3.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_main, MyRatingFragment())
                .commit()
        }
        binding.ivRectangle4.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_main, MyProfileFragment())
                .commit()
        }

    }
    private fun setTitleGradient(text: String, tv: TextView) {
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, ContextCompat.getColor(requireContext(), R.color.pink_100), ContextCompat.getColor(requireContext(), R.color.purple_100))
        tv.text = spannable
    }

}