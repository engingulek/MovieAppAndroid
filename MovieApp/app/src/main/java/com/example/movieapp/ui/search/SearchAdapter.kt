package com.example.movieapp.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.SearchMoviePosterDesignBinding
import com.example.movieapp.utils.PicassoImage

class SearchAdapter(var mContext:Context,var list:List<Movie>)
    :RecyclerView.Adapter<SearchAdapter.SearchDesignKeeper>(){
        inner  class SearchDesignKeeper(design:SearchMoviePosterDesignBinding)
            : RecyclerView.ViewHolder(design.root){
                var design:SearchMoviePosterDesignBinding
                init {
                    this.design = design
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDesignKeeper {
        val layoutInflater = LayoutInflater.from(mContext)
        val design:SearchMoviePosterDesignBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.search_movie_poster_design,
            parent,
            false
        )
        return  SearchDesignKeeper(design)
    }

    override fun getItemCount(): Int {
        return  list.count()
    }

    override fun onBindViewHolder(holder: SearchDesignKeeper, position: Int) {
        val movie = list[position]
        holder.design.nameTxt.text = movie.name
        PicassoImage.covertToPicasso(movie.imageURL,holder.design.movieImage)
        holder.design.categoryTxt.text = movie.categories.joinToString(", ")
        holder.design.movieInfoTxt.text = movie.info
    }
}