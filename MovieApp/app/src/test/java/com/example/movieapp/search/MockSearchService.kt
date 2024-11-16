package com.example.movieapp.search

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.ui.home.models.Category
import com.example.movieapp.ui.search.Movie
import com.example.movieapp.ui.search.SearchFragmentServiceInterface

class MockSearchService : SearchFragmentServiceInterface {
    private var resultMovieList:MutableLiveData<Pair<List<Movie>,Boolean>> = MutableLiveData()
     var responseCode:Int = 200
    var emptyResultListState:Boolean = false

    override fun getMovieResult(): MutableLiveData<Pair<List<Movie>, Boolean>> {
        return  resultMovieList
    }

    override fun fetchAllMovie() {
        val categoryList : List<String>  = listOf(

            "testCategory1",
            "testCategory2"
        )
        val list : List<Movie> = listOf(
            Movie(1,
                "testUrl",
                "testName",categoryList,"testInfo")
        )

        if (responseCode != 200){
            resultMovieList = MutableLiveData(Pair(emptyList(),true))
        }else{
            resultMovieList = MutableLiveData(Pair(list,false))
        }
    }

    override fun searchMovie(text: String) {
        val categoryList : List<String>  = listOf(

            "testCategory1",
            "testCategory2"
        )
        val resultList : List<Movie> = listOf(
            Movie(1,
                "testUrl",
                "testName",categoryList,"testInfo")
        )
        if (emptyResultListState){
            resultMovieList = MutableLiveData(Pair(emptyList(),true))
        }else{
            resultMovieList = MutableLiveData(Pair((resultList),false))
        }

        if (responseCode != 200){
            resultMovieList = MutableLiveData(Pair(emptyList(),true))
        }
    }
}