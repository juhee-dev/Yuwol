package com.yuwol.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yuwol.R
import com.yuwol.databinding.FragmentSettingsInfoBinding
import com.yuwol.databinding.FragmentSettingsWithdrawalBinding

class SettingsWithdrawalFragment : Fragment() {
    lateinit var binding: FragmentSettingsWithdrawalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsWithdrawalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivChartAllBack.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,MySettingsFragment()).commit()
        }
    }
}