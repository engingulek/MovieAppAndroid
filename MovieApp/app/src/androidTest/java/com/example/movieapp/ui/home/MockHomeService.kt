package com.example.movieapp.ui.home

import com.example.movieapp.ui.home.models.Category

class MockHomeService : HomeViewServiceInterface {
    override fun fetchCategories(): List<Category> {
        val list : List<Category>  = listOf(

            Category(1,"")
        )
       return  list
    }
}