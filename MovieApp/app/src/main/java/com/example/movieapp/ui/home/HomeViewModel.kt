package com.example.movieapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.R
import com.example.movieapp.ui.home.models.Category
import dagger.hilt.android.lifecycle.HiltViewModel
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
      // categories.value = service.fetchCategories()
    }

}