package com.raja.e_catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_book.view.*

class SampleAdapter(var books: Books):RecyclerView.Adapter<SampleAdapter.SampleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false)
        return SampleHolder(view)
    }

    override fun onBindViewHolder(holder: SampleHolder, position: Int) {
        val items = books.items!![position]
        holder.tvTitle.text = items?.volumeInfo?.title
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class SampleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.tv_title
    }
}