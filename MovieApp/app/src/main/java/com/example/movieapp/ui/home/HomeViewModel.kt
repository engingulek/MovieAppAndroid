package com.example.movieapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.R

import com.example.movieapp.ui.home.models.Category
import com.example.movieapp.ui.search.Movie
import com.example.movieapp.utils.Titles
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface  HomeViewModelInterface {
    var categories :MutableLiveData<List<Category>>
    var movies : MutableLiveData<List<Movie>>
    var titles: Titles
    var navSearchFragmentState:MutableLiveData<Boolean>
    var searchText:String
    fun onClickCategory(category: Category)
    fun categoryDesignType(id:Int) : Pair<Int,Int>
    fun searchViewOnQueryTextListener(text:String)




}
@HiltViewModel
class HomeViewModel @Inject constructor (private val service:HomeViewServiceInterface,
                                        ) :
    ViewModel(),HomeViewModelInterface {

    override var categories = MutableLiveData<List<Category>>()
    override var movies = MutableLiveData<List<Movie>>()

    override var titles = Titles(R.string.app_name,R.string.categoryTitle,R.string.movieTitle)
    override var navSearchFragmentState: MutableLiveData<Boolean>

    override var searchText:String
    private  var tempMovies = MutableLiveData<List<Movie>>()
   private var selectedCategoryId:Int

    init {
        service.fetchCategories()
        service.fetchMovies()
        categories = service.getCategories()
        movies = service.getAllMovie()
        tempMovies = service.getAllMovie()
        selectedCategoryId = categories.value?.first()?.id ?: 1
        navSearchFragmentState = MutableLiveData(false)
        searchText = ""
        }

    override fun onClickCategory(category: Category) {
       selectedCategoryId = category.id
        filterMovie(category)
    }

    override fun categoryDesignType(id: Int): Pair<Int, Int> {
        val design:Pair<Int,Int>
        if(selectedCategoryId == id) {
            design = Pair(R.color.secondaryTextViewColor,R.color.white)
        }else{
            design = Pair(R.color.secondaryBackColor,R.color.black)
        }
        return  design
    }

    override fun searchViewOnQueryTextListener(text: String) {
        if (text.count() > 3){
            searchText = text
            navSearchFragmentState.value = true
            searchText = ""
            navSearchFragmentState.value = false
        }
    }

    private fun filterMovie(category: Category){
        if (category.id == 1) {
            movies = tempMovies
        }else{
            tempMovies.value?.let {
                movies.value = it.filter { it.categories.contains(category.name) }
            }
        }

    }
}