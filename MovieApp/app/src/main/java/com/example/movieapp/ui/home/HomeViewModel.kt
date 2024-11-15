package com.example.movieapp.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.R

import com.example.movieapp.ui.home.models.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference
import javax.inject.Inject

interface  HomeViewModelInterface {
    var categories :MutableLiveData<List<Category>>
    var titles:Titles


}
@HiltViewModel
class HomeViewModel @Inject constructor (private val service:HomeViewServiceInterface,
                                        ) :
    ViewModel(),HomeViewModelInterface {

    override var categories = MutableLiveData<List<Category>>()
    override var titles = Titles(R.string.app_name,R.string.categoryTitle,R.string.trendTitle,R.string.forYouTitle)


    init {
        getCategories()

        }

    private fun getCategories() {
        service.fetchCategories()
        categories = service.getCategories()


    }

}