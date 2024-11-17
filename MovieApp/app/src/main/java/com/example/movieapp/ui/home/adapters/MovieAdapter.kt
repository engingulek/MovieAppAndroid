package com.example.movieapp.ui.home.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.MoviePosterDesignBinding
import com.example.movieapp.ui.home.HomeFragmentDirections
import com.example.movieapp.ui.search.Movie
import com.example.movieapp.utils.PicassoImage
import com.example.movieapp.utils.toFragment

class MovieAdapter(var mContext: Context,var list: List<Movie>)
    : RecyclerView.Adapter<MovieAdapter.MoviePosterDesignKeeper>() {
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
        return  list.count()
    }

    override fun onBindViewHolder(holder: MoviePosterDesignKeeper, position: Int) {
        val movie = list[position]
        holder.design.movieNameTxt.text = movie.name
        PicassoImage.covertToPicasso(movie.imageURL,holder.design.moviePosterImage)
        holder.design.cardView.setOnClickListener {
            val nav = HomeFragmentDirections.toDetailFromHome(1)
            Navigation.toFragment(it,nav)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun reloadAdapter(){
        notifyDataSetChanged()
    }
}