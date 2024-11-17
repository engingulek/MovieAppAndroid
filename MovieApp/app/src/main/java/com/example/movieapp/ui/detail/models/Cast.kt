package com.example.movieapp.ui.detail.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Cast (
   @SerializedName("id") val id: Int,
   @SerializedName("name")   val name: String,
   @SerializedName("rolename") val roleName:String,
   @SerializedName("imageurl")  val imageUrl: String
) : Serializable
