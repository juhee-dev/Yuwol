package com.yuwol.fragment

import android.content.Intent
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
import com.yuwol.LinearGradientSpan
import com.yuwol.R
import com.yuwol.SignUpActivity
import com.yuwol.databinding.FragmentUserBinding

class UserFragment : Fragment() {
    lateinit var binding: FragmentUserBinding
    val TAG = "USER"

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

        setMemberInfo()

        setTitleGradient(binding.textView.text.toString(), binding.textView)
        setSettingsGradient(binding.textView3.text.toString(), binding.textView3)
        setSettingsGradient(binding.textView4.text.toString(), binding.textView4)
        setSettingsGradient(binding.textView5.text.toString(), binding.textView5)
        setSettingsGradient(binding.textView6.text.toString(), binding.textView6)
        setSettingsGradient(binding.textView7.text.toString(), binding.textView7)

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

        binding.ivRectangle5.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_main, MySettingsFragment())
                .commit()
        }

    }

    private fun setMemberInfo() {
        val name = arguments?.getString("name")
        val image_uri = arguments?.getString("image")
        val introduce = arguments?.getString("introduce")

        Log.d(TAG, "setMemberInfo: name=${name} introduce=${introduce}")

        binding.tvUserName.text = name
        binding.ivUserProfile.setImageResource(R.drawable.login_logo)
        binding.tvUserIntroduce.text = introduce
    }

    private fun setTitleGradient(text: String, tv: TextView) {
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, ContextCompat.getColor(requireContext(), R.color.pink_300), ContextCompat.getColor(requireContext(), R.color.purple_300))
        tv.text = spannable
    }

    private fun setSettingsGradient(text: String, tv: TextView) {
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, ContextCompat.getColor(requireContext(), R.color.pink_400), ContextCompat.getColor(requireContext(), R.color.purple_100))
        tv.text = spannable
    }

}