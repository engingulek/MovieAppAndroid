package com.example.movieapp.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun  Navigation.toFragment(view:View,directionId:Int) {
    findNavController(view).navigate(directionId)
}

fun  Navigation.toFragment(view:View,directionId:NavDirections) {
    findNavController(view).navigate(directionId)
}

fun Navigation.popFragment(view:View){
    findNavController(view).popBackStack()
}