package com.example.movieapp.ui.search

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie (
   @SerializedName("id")  val id: Int,
  @SerializedName("imageUrl")  val imageURL: String,
  @SerializedName("name")   val name: String,
  @SerializedName("categories")   val categories: List<String>,
  @SerializedName("info")  val info: String
) : Serializable