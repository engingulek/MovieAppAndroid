package com.example.movieapp.ui.home.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HomeMovie (
   @SerializedName("id") val id: Long,
   @SerializedName("name") val name: String,
   @SerializedName("imageUrl") val imageUrl: String
) : Serializable
