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
import com.yuwol.databinding.FragmentMyProfileBinding
import com.yuwol.databinding.FragmentSettingsInfoBinding

class SettingsInfoFragment : Fragment() {
    lateinit var binding: FragmentSettingsInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsInfoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitleGradient("정보", binding.tvSettingsInfoTitle)

        binding.ivRectangle.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,InfoTosFragment())
                .commit()
        }
        binding.ivRectangle2.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_main, InfoPolicyFragment())
                .commit()
        }

        binding.ivSettingsInfoBack.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,MySettingsFragment()).commit()
        }
    }

    private fun setTitleGradient(text: String, tv: TextView) {
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, ContextCompat.getColor(requireContext(), R.color.pink_300), ContextCompat.getColor(requireContext(), R.color.purple_300))
        tv.text = spannable
    }
}