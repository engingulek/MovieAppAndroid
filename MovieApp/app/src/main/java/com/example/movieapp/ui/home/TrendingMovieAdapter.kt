package com.example.movieapp.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.MoviePosterDesignBinding

class TrendingMovieAdapter(var mContext: Context)
    : RecyclerView.Adapter<TrendingMovieAdapter.MoviePosterDesignKeeper>() {
        inner class  MoviePosterDesignKeeper(design:MoviePosterDesignBinding)
            :RecyclerView.ViewHolder(design.root){
                var design:MoviePosterDesignBinding
                init {
                    this.design = design
                }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePosterDesignKeeper {
        val layoutInflater = LayoutInflater.from(mContext)
        val design:MoviePosterDesignBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.movie_poster_design,
            parent,
            false)
        return  MoviePosterDesignKeeper(design)
    }

    override fun getItemCount(): Int {
        return  10
    }

    override fun onBindViewHolder(holder: MoviePosterDesignKeeper, position: Int) {

    }
}