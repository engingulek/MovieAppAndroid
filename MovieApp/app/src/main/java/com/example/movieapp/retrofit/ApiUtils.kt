package com.example.movieapp.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://10.0.2.2:8080/api/"
        fun createService() : ApiService {
            return RetrofitClient.getClient(BASE_URL).create(ApiService::class.java)
        }
    }
}
