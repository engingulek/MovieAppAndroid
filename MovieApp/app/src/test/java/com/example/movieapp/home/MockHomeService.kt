package com.example.movieapp.home

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.ui.home.HomeViewServiceInterface
import com.example.movieapp.ui.home.models.Category

class MockHomeService : HomeViewServiceInterface {
    private  var categoryList = MutableLiveData<List<Category>>()
    override fun getCategories(): MutableLiveData<List<Category>> {

        return categoryList
    }

    override fun fetchCategories() {
        val list : List<Category>  = listOf(

            Category(id=1, name="TestCategory1"),
            Category(id=2, name="TestCategory2"),
            Category(id=3, name="TestCategory3")
        )
       categoryList = MutableLiveData(list)
    }
}