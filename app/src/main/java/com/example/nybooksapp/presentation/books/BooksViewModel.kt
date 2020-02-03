package com.example.nybooksapp.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nybooksapp.data.ApiService
import com.example.nybooksapp.data.model.Book
import com.example.nybooksapp.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
        //booksLiveData.value = createFakeBooks()
        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse> {

            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {

                if (response.isSuccessful) {
//                    val books: MutableList<Book> = mutableListOf()

                    response.body()?.let { bookBodyResponse ->
                        val books = bookBodyResponse.results.map {
                            Book(
                                title = it.book_details[0].title,
                                author = it.book_details[0].author,
                                description = it.book_details[0].description
                            )
                        }
                        booksLiveData.value = books
//                        for (result in bookBodyResponse.results) {
//                            val bookApi = Book(
//                                title = result.book_details[0].title,
//                                author = result.book_details[0].author,
//                                description = result.book_details[0].description
//                            )
//                            books.add(bookApi)
//                        }
                    }


                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) { }
        })
    }


    //Criação para quando não era feita a integração com a API ainda
    fun createFakeBooks(): List<Book> {
        return listOf(
            Book("Titulo do Livro", "Autor do Livro", "Livro legal"),
            Book("Titulo do Livro", "Autor do Livro", "Livro  massa")
        )
    }

}