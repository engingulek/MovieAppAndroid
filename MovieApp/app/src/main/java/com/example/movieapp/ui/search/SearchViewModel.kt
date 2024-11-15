package com.example.movieapp.ui.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs

interface  SearchViewModelInterface {

    fun getSearchText(text:String)
}

class SearchViewModel : ViewModel(),SearchViewModelInterface {

    override fun getSearchText(text: String) {

    }
}