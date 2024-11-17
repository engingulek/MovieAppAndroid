package com.example.movieapp.utils

import com.example.movieapp.R

data class AlertMessageType(
    var title:Int,
    var message:Int,
    var buttonText:Int
){
    companion object {
        val defaultAlertMessage = AlertMessageType(
            R.string.errorTitle,
            R.string.errorMessage,
            R.string.errorButtonTitle)
    }
}