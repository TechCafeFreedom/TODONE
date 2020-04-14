package com.techcafe.todone.board.ui

import com.techcafe.todone.board.databinding.ViewItemBinding
import com.techcafe.todone.board.model.SampleModel

internal class BoardViewHolder(private val binding: ViewItemBinding){

    fun bind(item: SampleModel) {
        binding.apply {
            model = item
            executePendingBindings()
        }
    }
}
