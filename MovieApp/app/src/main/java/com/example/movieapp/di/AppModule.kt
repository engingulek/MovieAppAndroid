package com.example.movieapp.di

import com.example.movieapp.retrofit.ApiService
import com.example.movieapp.retrofit.ApiUtils
import com.example.movieapp.ui.detail.MovieDetailService
import com.example.movieapp.ui.detail.MovieDetailServiceInterface
import com.example.movieapp.ui.home.HomeFragment

import com.example.movieapp.ui.home.HomeViewService
import com.example.movieapp.ui.home.HomeViewServiceInterface
import com.example.movieapp.ui.search.SearchFragmentService
import com.example.movieapp.ui.search.SearchFragmentServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    // ProvideApiService
    @Provides
    @Singleton
    fun provideApiService() : ApiService {
        return  ApiUtils.createService()
    }

    // ProvideHomeViewService
    @Provides
    @Singleton
    fun provideHomeViewService(apiService: ApiService): HomeViewServiceInterface {
        val service:HomeViewServiceInterface = HomeViewService(apiService)
        return service
    }

    // ProvideSearchFragmentService
    @Provides
    @Singleton
    fun provideSearchFragmentService(apiService: ApiService) : SearchFragmentServiceInterface {
        val service : SearchFragmentServiceInterface = SearchFragmentService(apiService)
        return  service
    }

    // ProvideDetailService
    @Provides
    @Singleton
    fun provideDetailService(apiService: ApiService) : MovieDetailServiceInterface {
        val service : MovieDetailServiceInterface = MovieDetailService(apiService)
        return  service
    }
}