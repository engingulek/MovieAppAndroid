package com.example.movieapp.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.retrofit.ApiService
import com.example.movieapp.ui.detail.models.Cast
import com.example.movieapp.ui.detail.models.MovieDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

interface MovieDetailServiceInterface {
    fun getMovieDetail() : MutableLiveData<MovieDetail>
    fun getCasts() : MutableLiveData<List<Cast>>
    fun fetchMovieDetail(id:Int)
    fun fetchCast(movieId:Int)
}

class MovieDetailService(private val apiService: ApiService) : MovieDetailServiceInterface {
    private var movieDetail : MutableLiveData<MovieDetail> = MutableLiveData()
    private var casts : MutableLiveData<List<Cast>> = MutableLiveData()
    override fun getMovieDetail(): MutableLiveData<MovieDetail> {
        return movieDetail
    }

    override fun getCasts(): MutableLiveData<List<Cast>> {
        return casts
    }

    override fun fetchMovieDetail(id: Int) {
        apiService.getDetail(id).enqueue(object: Callback<MovieDetail>{
            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                val data = response.body()
               data?.let {
                   movieDetail.value = it

               }
            }

            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {

            }

        } )
    }


    override fun fetchCast(movieId: Int) {
        apiService.getCastsByMovieId(movieId).enqueue(object : Callback<List<Cast>>{
            override fun onResponse(call: Call<List<Cast>>, response: Response<List<Cast>>) {
                val list = response.body() ?: emptyList();
                casts.value = list
                Log.e("cast list","${list}")
            }

            override fun onFailure(call: Call<List<Cast>>, t: Throwable) {
                casts.value = emptyList()
            }

        })
    }

}