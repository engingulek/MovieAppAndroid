package com.example.movieapp.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentSearchBinding

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
        val searchAdapter = SearchAdapter(requireContext())
        design.searchAdapter = searchAdapter
        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SearchViewModelInterface by viewModels<SearchViewModel>()
        viewModel = tempViewModel
    }



}