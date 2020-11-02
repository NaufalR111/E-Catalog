package com.raja.e_catalog

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_book.view.*

class BookAdapter(var context: Context, var books: Books) :
    RecyclerView.Adapter<BookAdapter.BookHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookHolder(view)
    }

    override fun getItemCount(): Int {
        return books.items!!.size
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val items = books.items!![position]
        holder.tvTitle.text = items?.volumeInfo?.title
        holder.tvAuthor.text = items?.volumeInfo?.authors!![0]
        Glide.with(context)
            .load(items.volumeInfo.imageLinks?.thumbnail)
            .into(holder.ivCover)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, BookDetailActivity::class.java)
            intent.putExtra("books", books.items!![position])
            context.startActivity(intent)
        }
    }

    class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivCover = itemView.iv_cover
        val tvTitle = itemView.tv_title
        val tvAuthor = itemView.tv_author
    }
}