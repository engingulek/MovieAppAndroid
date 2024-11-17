package com.example.movieapp.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface SearchFragmentServiceInterface {

    fun getMovieResult():MutableLiveData<Pair<List<Movie>,Boolean>>
    fun fetchAllMovie()
    fun searchMovie(text:String)
}

class SearchFragmentService(private val apiService: ApiService) : SearchFragmentServiceInterface  {

    private var resultMovieList:MutableLiveData<Pair<List<Movie>,Boolean>> = MutableLiveData()

    override fun getMovieResult(): MutableLiveData<Pair<List<Movie>, Boolean>> {
        return  resultMovieList
    }

    override fun searchMovie(text:String) {
        apiService.searchMovie(text).enqueue(object :Callback<List<Movie>>{
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                val list = response.body()

                resultMovieList.value = Pair(list ?: emptyList(),false)
                if (response.code() != 200) {
                    resultMovieList.value = Pair(emptyList(),true)
                }
            }
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                resultMovieList.value = Pair(emptyList(),true)

            }
        })
    }

    override fun fetchAllMovie() {
        apiService.getAllMovie().enqueue(object :Callback<List<Movie>>{
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                val list = response.body()
                resultMovieList.value = Pair(list ?: emptyList(),false)
                if (response.code() != 200) {
                    resultMovieList.value = Pair(emptyList(),true)
                }
            }
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                resultMovieList.value = Pair(emptyList(),true)
            }
        })
    }
}