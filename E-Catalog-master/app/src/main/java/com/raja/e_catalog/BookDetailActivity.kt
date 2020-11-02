package com.raja.e_catalog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val book = intent.extras?.getSerializable("books") as Books.Item
        Glide.with(this)
            .load(book.volumeInfo?.imageLinks?.thumbnail)
            .into(iv_cover)

        tv_title.text = book.volumeInfo?.title
        tv_description.text = book.volumeInfo?.description
    }
}