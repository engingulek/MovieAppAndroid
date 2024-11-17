package com.example.movieapp.ui.home.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category(
    @SerializedName("id") var id:Int,
    @SerializedName("name")  var name:String,
                  ): Serializable
