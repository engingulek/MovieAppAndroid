package com.example.movieapp.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private lateinit var design:FragmentSearchBinding
    private lateinit var viewModel:SearchViewModelInterface
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_search, container, false)
        val bundle:SearchFragmentArgs by  navArgs()
        val searchText = bundle.searchText
        viewModel.getSearchText(searchText)
        design.searchView.setQuery(searchText,true)
        design.searchView.isIconified = false
        design.searchRyc.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)

        viewModel.searchMovieList.observe(viewLifecycleOwner){
            val searchAdapter = SearchAdapter(requireContext(),it)
            design.searchAdapter = searchAdapter
        }

        design.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return  false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    viewModel.getSearchText(it)
                }
                return true
            }
        })


        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SearchViewModelInterface by viewModels<SearchViewModel>()
        viewModel = tempViewModel
    }



}