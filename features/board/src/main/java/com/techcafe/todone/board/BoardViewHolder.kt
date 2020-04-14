package com.techcafe.todone.board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techcafe.todone.board.databinding.ViewItemBinding

internal class BoardViewHolder(itemView: View, private val binding: ViewItemBinding) :
    RecyclerView.ViewHolder(itemView) {
    companion object {
        fun create(
            inflater: LayoutInflater,
            container: ViewGroup,
            attachToRoot: Boolean
        ): BoardViewHolder {
            val binding = ViewItemBinding.inflate(inflater, container, attachToRoot)
            return BoardViewHolder(binding.root, binding)
        }
    }

    fun bind(item: SampleModel) {
        binding.apply {
            model = item
            executePendingBindings()
        }
    }
}
