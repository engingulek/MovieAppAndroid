package com.example.movieapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.ui.home.adapters.CategoryAdapter
import com.example.movieapp.ui.home.adapters.ForYouMovieAdapter
import com.example.movieapp.ui.home.adapters.TrendingMovieAdapter

interface HomeFragmentInterface {

    fun setTitle(appTitle:Int,
                 categoryTitle:Int,
                 trendTitle:Int,
                 forYouTitle:Int)
    fun configureAdapters()
}

class HomeFragment : Fragment(),HomeFragmentInterface {
    private lateinit var design : FragmentHomeBinding
     private lateinit  var viewModel:HomeViewModelInterface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)



        val viewModelFactory = HomeViewModelFactory(this)
        val tempViewModel:HomeViewModelInterface by viewModels<HomeViewModel>{viewModelFactory}
        viewModel = tempViewModel

        return  design.root
    }

    override fun setTitle(appTitle:Int,
                          categoryTitle:Int,
                          trendTitle:Int,
                          forYouTitle:Int) {
        design.appTitleTxt.text = getString(appTitle)
        design.categoryTitleTxt.text = getString(categoryTitle)
        design.trendingTitleTxt.text = getString(trendTitle)
        design.forYouTitle.text = getString(forYouTitle)
    }

    override fun configureAdapters() {
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