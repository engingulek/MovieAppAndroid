package com.example.movieapp.ui.home
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.retrofit.ApiService

import com.example.movieapp.ui.home.models.Category
import com.example.movieapp.ui.search.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface HomeViewServiceInterface {
     fun getCategories(): MutableLiveData<List<Category>>
     fun fetchCategories()

     fun getAllMovie() :  MutableLiveData<List<Movie>>
     fun fetchMovies()
}

class HomeViewService(private val apiService: ApiService) : HomeViewServiceInterface {
    private  var categoryList : MutableLiveData<List<Category>> = MutableLiveData()
    private var movieList :  MutableLiveData<List<Movie>> = MutableLiveData()

    override fun getCategories(): MutableLiveData<List<Category>> {
        return categoryList
    }

    override  fun fetchCategories() {
        apiService.getAllCategory().enqueue(object : Callback<List<Category>> {
            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
                val list = response.body()
               categoryList.value = list ?: emptyList()
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                categoryList.value = emptyList()
            }
        })
    }

    override fun getAllMovie(): MutableLiveData<List<Movie>> {
        return  movieList
    }


    override fun fetchMovies() {
        apiService.getAllMovie().enqueue(object : Callback<List<Movie>> {
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
