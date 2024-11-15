package com.example.movieapp.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.ui.home.models.Category

class MockHomeService : HomeViewServiceInterface {
    override fun fetchCategories(): MutableLiveData<List<Category>> {
        val list : List<Category>  = listOf(

            Category(1,"test")
        )
       return MutableLiveData(list)
    }
}