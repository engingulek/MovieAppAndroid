package com.example.movieapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.ui.detail.models.Cast
import com.example.movieapp.ui.detail.models.MovieDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


interface  MovieDetailViewModelInterface {
    var movieDetail:MutableLiveData<MovieDetail>
    var casts : MutableLiveData<List<Cast>>
    fun getId(id:Int)
}

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val service:MovieDetailServiceInterface) :
 ViewModel(),MovieDetailViewModelInterface{
     override var movieDetail : MutableLiveData<MovieDetail>  = MutableLiveData()
    override var casts: MutableLiveData<List<Cast>> = MutableLiveData()

    override fun getId(id: Int) {
        service.fetchMovieDetail(1)
        movieDetail = service.getMovieDetail()
        service.fetchCast(id)
        casts = service.getCasts()
    }
}