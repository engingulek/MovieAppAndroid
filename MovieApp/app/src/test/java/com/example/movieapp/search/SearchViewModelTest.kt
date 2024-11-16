package com.example.movieapp.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.movieapp.R
import com.example.movieapp.ui.search.Movie
import com.example.movieapp.ui.search.SearchFragmentServiceInterface
import com.example.movieapp.ui.search.SearchViewModel
import com.example.movieapp.ui.search.SearchViewModelInterface
import org.junit.Before
import org.junit.Test
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.mockito.ArgumentMatchers.argThat
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class SearchViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: SearchViewModel
    private lateinit var mockService: MockSearchService
    private lateinit var mockObserver: Observer<Pair<Int, Boolean>>

    @Before()
    fun setup(){
        mockService = MockSearchService()
        viewModel = SearchViewModel(mockService)
        mockObserver = mock(Observer::class.java) as Observer<Pair<Int, Boolean>>


        viewModel.message.observeForever(mockObserver)
    }



    @Test
    fun `when search text is empty, message should be emptyDefault`() {

        viewModel.getSearchText("")
        verify(mockObserver).onChanged(Pair( R.string.emptyDefault,false))
    }

    @Test
    fun `when search fails, message should be errorMessage`() {


        mockService.responseCode = 500
        viewModel.getSearchText("test")


        verify(mockObserver).onChanged(Pair( R.string.errorMessage ,true))
    }


    @Test
    fun `when search returns results, message should be emptyDefault`() {

        viewModel.getSearchText("test")

        verify(mockObserver).onChanged(Pair( R.string.emptyDefault ,false))
    }

    @Test
    fun `when search returns empty results, message should be emptyMovieList`() {

        mockService.emptyResultListState = true
        viewModel.getSearchText("test")


        verify(mockObserver).onChanged(
            Pair(  R.string.emptyMovieList , true)
        )
    }


}