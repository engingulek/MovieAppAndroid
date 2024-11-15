package com.example.movieapp.retrofit


import com.example.movieapp.ui.home.models.Category
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("category/getAll")
    fun getAllCategory() : Call<List<Category>>
}