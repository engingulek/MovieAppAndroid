package com.example.movieapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.R
import com.example.movieapp.ui.detail.models.Cast
import com.example.movieapp.ui.detail.models.MovieDetail
import com.example.movieapp.ui.search.Movie
import com.example.movieapp.utils.AlertMessageType
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Objects
import javax.inject.Inject


interface  MovieDetailViewModelInterface {
    var movieDetail:MutableLiveData<MovieDetail>
    var casts : MutableLiveData<List<Cast>>
    var message:MutableLiveData<Pair<AlertMessageType,Boolean>>
    fun getId(id:Int)
}

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val service:MovieDetailServiceInterface) :
 ViewModel(),MovieDetailViewModelInterface{
     override var movieDetail : MutableLiveData<MovieDetail>  = MutableLiveData()
    override var casts: MutableLiveData<List<Cast>>  = MutableLiveData()
    override var message:MutableLiveData<Pair<AlertMessageType,Boolean>> = MutableLiveData(Pair(AlertMessageType.defaultAlertMessage,false))

    override fun getId(id: Int) {
        service.fetchMovieDetail(id)
        movieDetail = service.getMovieDetail()
        service.fetchCast(id)

        service.getCasts().observeForever{ result  ->
            casts.value = result.first
            createMessage(result.second)
        }
    }

    private fun createMessage(errorState:Boolean) {
        if (errorState) {
            message.value =  Pair(AlertMessageType.defaultAlertMessage, true)
        }else{
            message.value = Pair(AlertMessageType.defaultAlertMessage, false)
        }
    }
}