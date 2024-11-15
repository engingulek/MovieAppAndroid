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
    fun onClickCategory(id:Int)
    fun categoryDesignType(id:Int) : Pair<Int,Int>


}
@HiltViewModel
class HomeViewModel @Inject constructor (private val service:HomeViewServiceInterface,
                                        ) :
    ViewModel(),HomeViewModelInterface {

    override var categories = MutableLiveData<List<Category>>()
    override var titles = Titles(R.string.app_name,R.string.categoryTitle,R.string.trendTitle,R.string.forYouTitle)
    var selectedCategoryId:Int

    init {
        service.fetchCategories()
        categories = service.getCategories()
        selectedCategoryId = categories.value?.first()?.id ?: 1
        }

    override fun onClickCategory(id: Int) {
       selectedCategoryId = id
    }

    override fun categoryDesignType(id: Int): Pair<Int, Int> {
        val design:Pair<Int,Int>
        if(selectedCategoryId == id) {
            design = Pair(R.color.secondaryTextViewColor,R.color.white)
            Log.e("${id}","${design.first} ${design.second}")
        }else{
            design = Pair(R.color.secondaryBackColor,R.color.black)
            Log.e("${id}","${design.first} ${design.second}")
        }
        return  design
    }
}