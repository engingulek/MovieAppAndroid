package com.example.movieapp.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.navArgs
import com.example.movieapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface  SearchViewModelInterface {

    var resultMovieList:MutableLiveData<Pair<List<Movie>,Boolean>>
    var message:MutableLiveData<Pair<Int,Boolean>>
    fun getSearchText(text:String)

}

@HiltViewModel
class SearchViewModel @Inject constructor(private val service: SearchFragmentServiceInterface)
    : ViewModel(),SearchViewModelInterface {


    override var message = MutableLiveData<Pair<Int,Boolean>>()
    override var resultMovieList = MutableLiveData<Pair<List<Movie>,Boolean>>()

    override fun getSearchText(text: String) {
        if (text.isEmpty()) {
            service.fetchAllMovie()}
        else {
            service.searchMovie(text)
        }

       service.getMovieResult().observeForever { result ->
            resultMovieList.value = result
           createMessage(result)
        }
    }

   private  fun createMessage(result: Pair<List<Movie>, Boolean>) {
        if(result.first.isEmpty()){
            if(result.second){
                message.value = Pair(R.string.errorMessage, true)
            }else{
                message.value = Pair(R.string.emptyMovieList, true)
            }
        }else{
            message.value = Pair(R.string.emptyDefault, false)
        }
    }
}