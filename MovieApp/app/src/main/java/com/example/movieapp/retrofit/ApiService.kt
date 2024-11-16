package com.example.movieapp.retrofit


import com.example.movieapp.ui.home.models.Category
import com.example.movieapp.ui.search.Movie

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("category/getAll")
    fun getAllCategory() : Call<List<Category>>
    @GET("movie/getAll")
    fun getAllMovie(): Call<List<Movie>>
    @GET("movie/searchMovie")
    fun searchMovie(@Query("text") text:String) : Call<List<Movie>>
}