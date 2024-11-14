package com.example.movieapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels

import dagger.hilt.android.AndroidEntryPoint
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.ui.home.adapters.CategoryAdapter
import com.example.movieapp.ui.home.adapters.ForYouMovieAdapter
import com.example.movieapp.ui.home.adapters.TrendingMovieAdapter


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var design : FragmentHomeBinding
     private lateinit  var viewModel:HomeViewModelInterface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        design = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)

        configureAdapters()
        setTitles()

        return  design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:HomeViewModelInterface by viewModels<HomeViewModel>()
        viewModel = tempViewModel
    }

    private fun setTitles() {
        val titles = viewModel.titles
        design.appTitleTxt.text = getString(titles.appTitle)
        design.trendingTitleTxt.text = getString(titles.trendTitle)
        design.categoryTitleTxt.text = getString(titles.categoryTitle)
        design.forYouTitle.text = getString(titles.forYouTitle)
    }


  private fun configureAdapters() {
        design.trendingMovieRyc.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val trendingMovieAdapter = TrendingMovieAdapter(requireContext())
        design.trendingMovieAdapter = trendingMovieAdapter

        design.categoryRyc.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val categoryAdapter = CategoryAdapter(requireContext())
        design.categoryAdapter = categoryAdapter

        design.forYouRyc.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val forYouAdapter = ForYouMovieAdapter(requireContext())
        design.forYouAdapter = forYouAdapter
    }



}