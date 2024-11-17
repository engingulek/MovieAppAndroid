package com.example.movieapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager

import dagger.hilt.android.AndroidEntryPoint
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.ui.home.adapters.CategoryAdapter
import com.example.movieapp.ui.home.adapters.MovieAdapter
import com.example.movieapp.utils.toFragment


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

        design.movieSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return  false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    viewModel.searchViewOnQueryTextListener(it)
                }
                return true
            }
        })

        viewModel.navSearchFragmentState.observe(viewLifecycleOwner){
            if (it) {
                val nav = HomeFragmentDirections.toSearchFragment(viewModel.searchText)
                Navigation.toFragment(requireView(),nav)
            }
        }

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
        design.moviesTxtTitle.text = getString(titles.movieTitle)
        design.categoryTitleTxt.text = getString(titles.categoryTitle)

    }


  private fun configureAdapters() {

      design.categoryRyc.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
      viewModel.categories.observe(viewLifecycleOwner){
          val categoryAdapter = CategoryAdapter(requireContext(),it,viewModel)
          design.categoryAdapter = categoryAdapter
      }

      design.movieRyc.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
      viewModel.movies.observe(viewLifecycleOwner){
          val movieAdapter = MovieAdapter(requireContext(),it)
          design.movieAdapter = movieAdapter
          movieAdapter.reloadAdapter()
      }
    }
}


