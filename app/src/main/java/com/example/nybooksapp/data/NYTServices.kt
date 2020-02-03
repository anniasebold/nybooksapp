package com.example.nybooksapp.data

import com.example.nybooksapp.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {

    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "17W7mg3eRcbRanwaer0CrU9jGl7pzWSf",
        @Query("list") list: String = "paperback-nonfiction"
    ): Call<BookBodyResponse>

}