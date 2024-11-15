package com.example.movieapp.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.CategoryDesignBinding
import com.example.movieapp.databinding.MoviePosterDesignBinding
import com.example.movieapp.ui.home.models.Category

class CategoryAdapter (var mContext: Context,var list: List<Category>)
    : RecyclerView.Adapter<CategoryAdapter.CategoryDesignKeeper>() {
    inner class  CategoryDesignKeeper(design: CategoryDesignBinding)
        : RecyclerView.ViewHolder(design.root){
        var design: CategoryDesignBinding
        init {
            this.design = design
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryDesignKeeper {
        val layoutInflater = LayoutInflater.from(mContext)
        val design: CategoryDesignBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.category_design,
            parent,
            false)
        return  CategoryDesignKeeper(design)
    }

    override fun getItemCount(): Int {
        return  list.count()
    }

    override fun onBindViewHolder(holder: CategoryDesignKeeper, position: Int) {
        holder.design.category = list[position]
    }
}