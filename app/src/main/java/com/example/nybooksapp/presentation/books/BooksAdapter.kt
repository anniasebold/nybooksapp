package com.example.nybooksapp.presentation.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nybooksapp.R
import com.example.nybooksapp.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdapter(
        private val books: List<Book>,
        private val onItemClickListener: ((book:Book) -> Unit)
) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent,false)
        return BooksViewHolder(itemView, onItemClickListener)
        //Layout de cada item do nosso RecyclerView
    }

    //Retorna a quantidade de itens que tem na lista
    override fun getItemCount() = books.count()

    override fun onBindViewHolder(viewHolder: BooksViewHolder, position: Int) {
        viewHolder.bindView(books[position])
        //Binda o nosso item da lista com o recycler view
    }

    class BooksViewHolder(
        itemView : View,
        private val onItemClickListener: ((book:Book) -> Unit))
        : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.bookTitle
        private val author = itemView.bookAuthor

        fun bindView(book: Book) {
            title.text = book.title
            author.text = book.author

            itemView.setOnClickListener {
                onItemClickListener.invoke(book)
            }

        }
    }

}