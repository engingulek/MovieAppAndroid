package com.example.movieapp.ui.home

import androidx.lifecycle.ViewModel
import com.example.movieapp.R
import java.lang.ref.WeakReference

interface  HomeViewModelInterface {


}

class HomeViewModel( val view: HomeFragmentInterface) :
    ViewModel(),HomeViewModelInterface {
    private val viewReference = WeakReference(view)
        init {

            viewReference.get()?.setTitle(
                R.string.app_name,
                R.string.categoryTitle,
                R.string.trendTitle,
                R.string.forYouTitle
            )
            viewReference.get()?.configureAdapters()
        }

}