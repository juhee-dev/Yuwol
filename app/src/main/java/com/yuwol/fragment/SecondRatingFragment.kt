package com.yuwol.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yuwol.R
import com.yuwol.adapter.RateAdapter
import com.yuwol.databinding.FragmentSecondRatingBinding
import com.yuwol.model.Rate


class SecondRatingFragment : Fragment() {

    lateinit var binding: FragmentSecondRatingBinding
    lateinit var song: Rate
    private lateinit var RateAdapter: RateAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondRatingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        arguments?.let {
//            song = it.getSerializable("rating") as Rate
//        }
//
//        binding.tvRating1Title.text = song.title
//        binding.tvRating1Artist.text = song.artist

        binding.ivRating1Back.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fl_main,ThirdRatingFragment()).commit()
        }
    }
}