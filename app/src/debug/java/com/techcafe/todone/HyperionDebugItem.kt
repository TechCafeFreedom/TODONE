package com.techcafe.todone

import android.content.Context
import androidx.annotation.DrawableRes

// add your own navigation to playground
data class HyperionDebugItem(
    val title: String,
    val description: String = "NO COMMENT",
    @DrawableRes val imageRes: Int = R.drawable.ic_magnifying_glass,
    val onItemClicked: (context: Context) -> Unit
) {
    companion object {
        fun createItems(): List<HyperionDebugItem> {
            return listOf(
                HyperionDebugItem(
                    title = "Zoo's Playground",
                    description = "俺が最強だ",
                ) {
                    val intent = ZooMainActivity.createIntent(it)
                    it.startActivity(intent)
                }
            )
        }
    }
}
