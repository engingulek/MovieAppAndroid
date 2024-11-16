package com.example.movieapp.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface SearchFragmentServiceInterface {
    fun getMovies():MutableLiveData<List<Movie>>
    fun fetchAllMovie()
    fun searchMovie(text:String)
}

class SearchFragmentService(private val apiService: ApiService) : SearchFragmentServiceInterface  {
    private var movieList : MutableLiveData<List<Movie>>

    init {
        movieList = MutableLiveData()
    }

    override fun getMovies(): MutableLiveData<List<Movie>> {
        return  movieList
    }

    override fun searchMovie(text:String) {
        apiService.searchMovie(text).enqueue(object :Callback<List<Movie>>{
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                val list = response.body()
                movieList.value = list ?: emptyList()
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                movieList.value = emptyList()
            }
        })
    }

    override fun fetchAllMovie() {
        apiService.getAllMovie().enqueue(object :Callback<List<Movie>>{
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                val list = response.body()
                movieList.value = list ?: emptyList()
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                movieList.value = emptyList()
            }
        })
    }
}