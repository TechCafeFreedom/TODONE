package com.techcafe.todone

import android.content.Context
import android.widget.Toast
import androidx.annotation.DrawableRes

// add your own navigation to playground
data class HyperionDebugItem(
    val title: String,
    val description: String = "NO COMMENT",
    @DrawableRes val imageRes: Int = R.drawable.ic_magnifying_glass,
    val onItemClicked: () -> Unit
) {
    companion object {
        fun createItems(context: Context): List<HyperionDebugItem> {
            return listOf(
                HyperionDebugItem(
                    title = "Zoo's Playground",
                    description = "俺が最強だ",
                ) {
                    Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}
