package com.yuwol.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yuwol.R
import com.yuwol.databinding.FragmentMyLikesBinding
import com.yuwol.databinding.FragmentMySinglistBinding

class MySinglistFragment : Fragment() {
    lateinit var binding: FragmentMySinglistBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMySinglistBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivChartAllBack.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,UserFragment()).commit()
        }
    }

}