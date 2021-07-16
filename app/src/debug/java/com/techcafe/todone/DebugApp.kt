package com.techcafe.todone

import com.github.takahirom.hyperion.plugin.simpleitem.SimpleItem
import com.github.takahirom.hyperion.plugin.simpleitem.SimpleItemHyperionPlugin

class DebugApp : App() {
    override fun onCreate() {
        super.onCreate()
        HyperionDebugItem.init(this).forEach { item ->
            val simpleItem = SimpleItem.Builder()
                .title(item.title)
                .text(item.description)
                .image(item.imageRes)
                .clickListener { item.onItemClicked() }
                .build()
            SimpleItemHyperionPlugin.addItem(simpleItem)
        }
    }
}
