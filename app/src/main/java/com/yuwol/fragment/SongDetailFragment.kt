package com.yuwol.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yuwol.R
import com.yuwol.databinding.FragmentSongDetailBinding
import com.yuwol.model.Rate
import com.yuwol.model.Song

class SongDetailFragment : Fragment() {
    lateinit var binding: FragmentSongDetailBinding
    lateinit var song: Song

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            song = it.getSerializable("song") as Song
        }

        binding.tvSongDetailTitle.text = song.title
        binding.tvSongDetailArtist.text = song.artist
        binding.tvSongDetailAlbum.text = song.album
        binding.tvSongDetailDate.text = song.date

        binding.ivSongDetailBack.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fl_main, HomeFragment()).commit()
        }

        binding.tvSongDetailMore.setOnClickListener {
            if (binding.clSongDetailMore.visibility == View.VISIBLE) {
                binding.clSongDetailMore.visibility = View.GONE
                binding.clSongDetailMore.animate().setDuration(200).rotation(180f)
            } else {
                binding.clSongDetailMore.visibility = View.VISIBLE
                binding.clSongDetailMore.animate().setDuration(200).rotation(0f)
            }
        }
    }
}