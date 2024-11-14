package com.example.movieapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.ui.home.adapters.CategoryAdapter
import com.example.movieapp.ui.home.adapters.ForYouMovieAdapter
import com.example.movieapp.ui.home.adapters.TrendingMovieAdapter


class HomeFragment : Fragment() {
    private lateinit var design : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        design.trendingMovieRyc.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val trendingMovieAdapter = TrendingMovieAdapter(requireContext())
        design.trendingMovieAdapter = trendingMovieAdapter
        design.categoryRyc.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val categoryAdapter = CategoryAdapter(requireContext())
        design.categoryAdapter = categoryAdapter

        design.forYouRyc.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val forYouAdapter = ForYouMovieAdapter(requireContext())
        design.forYouAdapter = forYouAdapter
        return  design.root
    }

}