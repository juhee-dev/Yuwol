package com.yuwol.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.yuwol.R
import com.yuwol.databinding.FragmentDialogBinding
import com.yuwol.databinding.FragmentFirstratingBinding
import com.yuwol.databinding.FragmentInfoPolicyBinding
import com.yuwol.databinding.FragmentMySettingsBinding

class DialogFragment : Fragment() {
    lateinit var binding: FragmentDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //false로 설정해 주면 화면밖 혹은 뒤로가기 버튼시 다이얼로그라 dismiss 되지 않는다.
        var isCancelable = true
    }


//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentDialogBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val text = "Hello, Welcome to blackjin Tisotry"
//
//        binding.btnSample.setOnClickListener {
//            Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
//        }
//    }

}