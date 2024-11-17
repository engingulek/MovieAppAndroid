package com.example.movieapp.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface MovieDetailServiceInterface {
    fun getMovieDetail() : MutableLiveData<MovieDetail>
    fun fetchMovieDetail(id:Int)
}

class MovieDetailService(private val apiService: ApiService) : MovieDetailServiceInterface {
    private var movieDetail : MutableLiveData<MovieDetail> = MutableLiveData()
    override fun getMovieDetail(): MutableLiveData<MovieDetail> {
        return movieDetail
    }

    override fun fetchMovieDetail(id: Int) {
        apiService.getDetail(id).enqueue(object: Callback<MovieDetail>{
            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                var data = response.body()
               data?.let {
                   movieDetail.value = it

               }

            }

            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {

            }

        } )
    }

}