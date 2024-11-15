package com.example.movieapp.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.ui.home.models.Category

interface HomeViewServiceInterface {
    //TODO:These will be suspend
    fun fetchCategories(): MutableLiveData<List<Category>>
}

class HomeViewService : HomeViewServiceInterface  {
    override fun fetchCategories(): MutableLiveData<List<Category>> {
        val categories = listOf(Category(1,"Drama"),Category(2,"Comedic"))
        return  MutableLiveData(categories)
    }
}