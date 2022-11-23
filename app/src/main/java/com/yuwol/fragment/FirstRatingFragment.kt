package com.yuwol.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yuwol.databinding.FragmentFirstratingBinding

class FirstRatingFragment : Fragment() {
    lateinit var binding: FragmentFirstratingBinding
    private var song = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstratingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            song = it.getString("rating").toString()
        }

        binding.tvRating1Title.text = song
        binding.tvRating1Artist.text = "artist"
    }
}