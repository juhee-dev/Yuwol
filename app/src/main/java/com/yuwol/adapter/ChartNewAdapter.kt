package com.yuwol.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yuwol.databinding.ItemHomeChartNewBinding
import com.yuwol.fragment.HomeFragment
import com.yuwol.model.SongTemp

class ChartNewAdapter(var link:HomeFragment.SongListAdapterToList) : RecyclerView.Adapter<ChartNewAdapter.ViewHolder>() {

    var dataList = mutableListOf<SongTemp>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeChartNewBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(dataList[position])
        holder.itemView.setOnClickListener {
            val song = dataList[position]
            link.getSong(song)
        }
    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolder(private val binding: ItemHomeChartNewBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(song: SongTemp){
            binding.ivChartCover.setImageResource(song.cover)
            binding.tvChartTitle.text = song.title
            binding.tvChartArtist.text = song.artist
            binding.tvChartDifficulty.text = song.difficulty
            binding.tvChartMood.text = song.mood
            binding.tvChartHigh.text = song.high
            binding.tvChartLow.text = song.low
            binding.tvChartRap.text = song.rap
        }
    }
}