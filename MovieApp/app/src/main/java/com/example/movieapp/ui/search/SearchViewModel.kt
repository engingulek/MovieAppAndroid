package com.example.movieapp.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface  SearchViewModelInterface {
    var searchMovieList : MutableLiveData<List<Movie>>
    fun getSearchText(text:String)
}
@HiltViewModel
class SearchViewModel @Inject constructor(private val service: SearchFragmentServiceInterface)
    : ViewModel(),SearchViewModelInterface {

    override var searchMovieList = MutableLiveData<List<Movie>>()

    override fun getSearchText(text: String) {
            if(text.isEmpty()){

                service.fetchAllMovie()
                searchMovieList = service.getMovies()

            }else{
                service.searchMovie(text)
                searchMovieList = service.getMovies()

            }
    }
}