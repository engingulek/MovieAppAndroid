package com.example.movieapp.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.CastDesignBinding
import com.example.movieapp.ui.detail.models.Cast
import com.example.movieapp.utils.PicassoImage

class CastAdapter (var mContext:Context,
    var casts : List<Cast>)
    : RecyclerView.Adapter<CastAdapter.CastDesignKeeper>() {
        inner class CastDesignKeeper(design:CastDesignBinding)
            : RecyclerView.ViewHolder(design.root){
                var design:CastDesignBinding
                init {
                    this.design = design
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastDesignKeeper {
        val layoutInflater = LayoutInflater.from(mContext)
        val design:CastDesignBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.cast_design,
            parent,false
        )
        return  CastDesignKeeper(design)
    }

    override fun getItemCount(): Int {
        return casts.count()
    }

    override fun onBindViewHolder(holder: CastDesignKeeper, position: Int) {
        val cast = casts[position]
        PicassoImage.covertToPicasso(cast.imageUrl,holder.design.castImage)
        holder.design.castNameTxt.text = cast.name
        holder.design.roleNameTxt.text = cast.roleName
    }
}