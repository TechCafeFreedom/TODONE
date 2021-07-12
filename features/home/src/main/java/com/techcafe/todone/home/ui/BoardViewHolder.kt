package com.techcafe.todone.home.ui

import androidx.recyclerview.widget.RecyclerView
import com.techcafe.todone.home.databinding.ViewItemBinding
import com.techcafe.todone.home.model.SampleModel

internal class BoardViewHolder(private val binding: ViewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: SampleModel) {
        binding.apply {
            model = item
            executePendingBindings()
        }
    }
}
