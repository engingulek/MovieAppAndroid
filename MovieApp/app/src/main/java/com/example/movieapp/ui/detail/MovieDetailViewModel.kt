package com.example.movieapp.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.ui.search.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


interface  MovieDetailViewModelInterface {
    var movieDetail:MutableLiveData<MovieDetail>
    fun getId(id:Int)
}

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val service:MovieDetailServiceInterface) :
 ViewModel(),MovieDetailViewModelInterface{
     override var movieDetail : MutableLiveData<MovieDetail>  = MutableLiveData()

    override fun getId(id: Int) {
        service.fetchMovieDetail(1)
        movieDetail = service.getMovieDetail()
    }
}