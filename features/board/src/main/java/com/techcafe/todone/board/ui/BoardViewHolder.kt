package com.techcafe.todone.board.ui

import androidx.recyclerview.widget.RecyclerView
import com.techcafe.todone.board.databinding.ViewItemBinding
import com.techcafe.todone.board.model.SampleModel

internal class BoardViewHolder(private val binding: ViewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: SampleModel) {
        binding.apply {
            model = item
            executePendingBindings()
        }
    }
}
