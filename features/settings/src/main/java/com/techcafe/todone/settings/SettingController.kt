package com.techcafe.todone.settings

import com.airbnb.epoxy.TypedEpoxyController

class SettingController : TypedEpoxyController<List<Pair<String, String>>>() {
    override fun buildModels(data: List<Pair<String, String>>?) {
        requireNotNull(data)
        data.forEachIndexed { index, pair ->
            val (title, message) = pair

            largeTitle {
                id("$index")
                value("$index つ目")
            }

            settingItem {
                id(title) // 1つ1つのModelを区別するために異なるidを割り当てる必要がある
                title(title)
                message(message)
            }
        }
    }
}