package com.raja.e_catalog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val API_BOOKS = "https://www.googleapis.com/books/v1/volumes?q=SEARCH"
    var requestQueue: RequestQueue? = null
    lateinit var adapter: BookAdapter
    lateinit var books: Books

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(this)

        getBooks()
    }

    fun getBooks() {
        val listener = Response.Listener<JSONObject> {
            books = Gson().fromJson(it.toString(), Books::class.java)
            val layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            rv_books.layoutManager = layoutManager
            adapter = BookAdapter(this, books)
            rv_books.adapter = adapter
            adapter.notifyDataSetChanged()
        }
        val errorList = Response.ErrorListener {
            println(it.toString())
        }
        val request = JsonObjectRequest(API_BOOKS, null, listener, errorList)
        requestQueue?.add(request)
    }
}