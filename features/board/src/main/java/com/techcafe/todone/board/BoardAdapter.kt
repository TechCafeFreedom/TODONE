package com.techcafe.todone.board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

internal class BoardAdapter : RecyclerView.Adapter<BoardViewHolder>() {
    private var list: List<SampleModel> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BoardViewHolder.create(inflater, parent, false)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItem(list: List<SampleModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size
}
