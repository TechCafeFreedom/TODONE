package com.techcafe.todone

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi

// add your own navigation to playground
data class HyperionDebugItem(
    val title: String,
    val description: String = "NO COMMENT",
    @DrawableRes val imageRes: Int = R.drawable.ic_magnifying_glass,
    val onItemClicked: () -> Unit
) {
    companion object {
        @RequiresApi(Build.VERSION_CODES.M)
        fun createItems(context: Context): List<HyperionDebugItem> {
            return listOf(
                HyperionDebugItem(
                    title = "Zoo's Playground",
                    description = "俺が最強だ",
                ) {
                    val intent = Intent(context, ZooMainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    context.startActivity(intent)
                }
            )
        }
    }
}
