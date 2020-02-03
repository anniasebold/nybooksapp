package com.example.nybooksapp.data.response

import com.google.gson.annotations.SerializedName

data class BookDetailsResponse (
    @SerializedName("author") val author:String,
    @SerializedName("title")  val title:String,
    @SerializedName("description") val description:String
)