package com.example.nybooksapp.data.response

import com.google.gson.annotations.SerializedName

data class BookResultsResponse (
    @SerializedName("book_details") val book_details: List<BookDetailsResponse>
)