package com.example.movieapp.home

import com.example.movieapp.R
import com.example.movieapp.ui.home.HomeViewModel
import com.example.movieapp.ui.home.HomeViewModelInterface
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {


    private lateinit var viewModel: HomeViewModelInterface
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
        assertEquals(R.string.movieTitle, viewModel.titles.movieTitle)
    }

    @Test
    fun categoryDesignType_WhenOpenApplication() {
        // default selected id = 1
        val selectedDesign = viewModel.categoryDesignType(1)
        assertEquals(R.color.secondaryTextViewColor, selectedDesign.first)
        assertEquals(R.color.white, selectedDesign.second)

        val noSelectedDesign = viewModel.categoryDesignType(2)
        assertEquals(R.color.secondaryBackColor, noSelectedDesign.first)
        assertEquals(R.color.black, noSelectedDesign.second)
    }

    @Test
    fun categoryDesignType_WhenOnClickCategory() {
        viewModel.onClickCategory(2)

        val selectedDesign = viewModel.categoryDesignType(2)
        assertEquals(R.color.secondaryTextViewColor, selectedDesign.first)
        assertEquals(R.color.white, selectedDesign.second)
        
        val noSelectedDesign = viewModel.categoryDesignType(1)
        assertEquals(R.color.secondaryBackColor, noSelectedDesign.first)
        assertEquals(R.color.black, noSelectedDesign.second)
    }
}