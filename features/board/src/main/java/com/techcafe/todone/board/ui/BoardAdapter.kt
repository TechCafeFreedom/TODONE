package com.techcafe.todone.board.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techcafe.todone.board.databinding.ViewItemBinding
import com.techcafe.todone.board.model.SampleModel

internal class BoardAdapter : RecyclerView.Adapter<BoardViewHolder>() {
    private var list: List<SampleModel> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewItemBinding.inflate(inflater, parent, false)
        return BoardViewHolder(binding)
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
