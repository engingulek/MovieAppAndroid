package com.example.movieapp.ui.home

import com.example.movieapp.R
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {


    private lateinit var viewModel:HomeViewModelInterface
    private lateinit var service: MockHomeService
    @Before
    fun setup(){
        service = MockHomeService()
        viewModel = HomeViewModel(service)
    }

    @Test
    fun titlesTextViews(){

        assertEquals(R.string.app_name, viewModel.titles.appTitle)
        assertEquals(R.string.categoryTitle, viewModel.titles.categoryTitle)
        assertEquals(R.string.trendTitle, viewModel.titles.trendTitle)
        assertEquals(R.string.forYouTitle, viewModel.titles.forYouTitle)
    }
}