package com.example.movieapp.ui.home

import com.example.movieapp.ui.home.models.Category

interface HomeViewServiceInterface {
    //TODO:These will be suspend
    fun fetchCategories(): List<Category>
}

class HomeViewService : HomeViewServiceInterface  {
    override fun fetchCategories(): List<Category> {
        val categotries = listOf(Category(1,"Drama"),Category(2,"Comedic"))
        return  categotries
    }
}