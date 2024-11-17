package com.example.movieapp.ui.detail.models

import com.google.gson.annotations.SerializedName

data class MovieDetail (
    @SerializedName("id") val id: Int,
    @SerializedName("imageURL") val imageURL: String,
    @SerializedName("name") val name: String,
    @SerializedName("categories") val categories: List<String>,
    @SerializedName("info")  val info: String,
    @SerializedName("director")  val director: List<String>,
    @SerializedName("writter")  val writter: List<String>,
    @SerializedName("detailimage")  val detailimage: String
)
