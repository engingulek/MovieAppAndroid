package com.example.movieapp.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.retrofit.ApiService

import com.example.movieapp.ui.home.models.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

interface HomeViewServiceInterface {
     fun getCategories(): MutableLiveData<List<Category>>
     fun fetchCategories()
}

class HomeViewService(private val apiService: ApiService) : HomeViewServiceInterface {
    private  var categoryList : MutableLiveData<List<Category>>
init {
    categoryList = MutableLiveData()
}

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
                Log.e("Categories Service","${list}")
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                categoryList.value = emptyList()
                Log.e("Category Error","${t.message}")
            }

        })
    }

}
