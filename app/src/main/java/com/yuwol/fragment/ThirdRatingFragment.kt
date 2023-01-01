package com.yuwol.fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.yuwol.R
import com.yuwol.databinding.FragmentSecondRatingBinding
import com.yuwol.databinding.FragmentThirdRatingBinding
import kotlinx.android.synthetic.main.fragment_third_rating.*
import kotlinx.android.synthetic.main.fragment_third_rating.view.*

class ThirdRatingFragment : Fragment() {
    lateinit var binding: FragmentThirdRatingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentThirdRatingBinding.inflate(inflater, container, false)
        return binding.root

        val view: View = inflater!!.inflate(R.layout.fragment_home, container, false)
        view.button.setOnClickListener {
            Log.d("console", "Button pressed")
        }
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,HomeFragment()).commit()
        }
    }

}