package com.example.movieapp.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.CastDesignBinding

class CastAdapter (var mContext:Context)
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
        return 5
    }

    override fun onBindViewHolder(holder: CastDesignKeeper, position: Int) {
        holder.design.castNameTxt.text = "Adad"
    }
}