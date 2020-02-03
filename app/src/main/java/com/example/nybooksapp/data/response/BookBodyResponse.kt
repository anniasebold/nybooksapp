package com.example.nybooksapp.data.response

import com.google.gson.annotations.SerializedName

data class BookBodyResponse (
    @SerializedName("results") val results: List<BookResultsResponse>
)