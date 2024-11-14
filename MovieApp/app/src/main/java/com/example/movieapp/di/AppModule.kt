package com.example.movieapp.di

import com.example.movieapp.ui.home.HomeFragment

import com.example.movieapp.ui.home.HomeViewService
import com.example.movieapp.ui.home.HomeViewServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideHomeViewService(): HomeViewServiceInterface {
        val service:HomeViewServiceInterface = HomeViewService()
        return service
    }
}