package com.example.movieapi

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapi.databinding.MovieItemBinding

class NowplayingAdepter (val list: List<ResultsItem?>?) : RecyclerView.Adapter<NowplayingAdepter.NowPlayingHolder>() {

    lateinit var context: Context

    class NowPlayingHolder(itemView: MovieItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingHolder {
        context = parent.context
        var binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NowPlayingHolder(binding)
    }

    override fun getItemCount(): Int {
        return list?.size!!
    }

    override fun onBindViewHolder(holder: NowPlayingHolder, position: Int) {
        holder.binding.apply {
            list?.get(position)?.apply {
                Glide.with(context).load(ApiClient.BASE_IMAGE_URL+ posterPath).into(imgPoster)
                txtTitle.text = originalTitle
            }
        }
    }

}