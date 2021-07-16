package com.techcafe.todone

import android.view.View
import android.widget.Toast
import com.github.takahirom.hyperion.plugin.simpleitem.SimpleItem
import com.github.takahirom.hyperion.plugin.simpleitem.SimpleItemHyperionPlugin

class DebugApp : App() {
    override fun onCreate() {
        super.onCreate()

        val item = SimpleItem.Builder()
            .title(getString(R.string.debug_navigation_title))
            .text(getString(R.string.debug_navigation_description))
            .image(R.drawable.ic_magnifying_glass)
            .clickListener { showToast(it) }
            .build()
        SimpleItemHyperionPlugin.addItem(item)
    }

    // TODO(zoothezoo): 2021/07/17 DebugActivityに遷移する
    private fun showToast(view: View) {
        view.setOnClickListener {
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
