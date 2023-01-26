package com.yuwol.fragment

import android.content.ContentValues.TAG
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
import com.yuwol.databinding.FragmentMyProfileBinding

class MyProfileFragment : Fragment() {
    lateinit var binding: FragmentMyProfileBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        setMemberInfo()

        binding.ivMyProfileBack.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,UserFragment()).commit()
        }
        binding.btnMyProfileSubmit.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,UserFragment()).commit()
        }
    }

//    private fun setMemberInfo() {
//        val name = arguments?.getString("name")
//        val image_uri = arguments?.getString("image")
//        val introduce = arguments?.getString("introduce")
//
//        Log.d(TAG, "프로필 수정: name=${name} introduce=${introduce}")
//
//        binding.etMyProfileName.setText(name)
//        binding.ivMyProfile.setImageResource(R.drawable.cover_antifragile)
//        binding.etMyProfileIntroduce.setText(introduce)
//    }
}