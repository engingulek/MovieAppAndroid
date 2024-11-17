package com.example.movieapp.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.retrofit.ApiService
import com.example.movieapp.ui.detail.models.Cast
import com.example.movieapp.ui.detail.models.MovieDetail
import com.example.movieapp.ui.search.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

interface MovieDetailServiceInterface {
    fun getMovieDetail() : MutableLiveData<MovieDetail>
    fun getCasts() : MutableLiveData<Pair<List<Cast>,Boolean>>
    fun fetchMovieDetail(id:Int)
    fun fetchCast(movieId:Int)
}

class MovieDetailService(private val apiService: ApiService) : MovieDetailServiceInterface {
    private var movieDetail : MutableLiveData<MovieDetail> = MutableLiveData()
    private var casts :  MutableLiveData<Pair<List<Cast>,Boolean>> = MutableLiveData()
    override fun getMovieDetail(): MutableLiveData<MovieDetail> {
        return movieDetail
    }

    override fun getCasts():  MutableLiveData<Pair<List<Cast>,Boolean>> {
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
                val list = response.body()
                if (list == null){
                    casts.value = Pair(emptyList(),true)
                }else{
                    casts.value = Pair(list,false)
                }

               if (response.code() != 200){
                   casts.value = Pair(emptyList(),true)
               }
            }

            override fun onFailure(call: Call<List<Cast>>, t: Throwable) {
                casts.value = Pair(emptyList(),true)
            }

        })
    }

}