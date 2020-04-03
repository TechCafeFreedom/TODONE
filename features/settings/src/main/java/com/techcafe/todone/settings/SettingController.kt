package com.techcafe.todone.settings

import com.airbnb.epoxy.TypedEpoxyController
import com.techcafe.todone.androidcomponent.largeTitle
import com.techcafe.todone.androidcomponent.spacing

class SettingController : TypedEpoxyController<List<Pair<String, String>>>() {
    override fun buildModels(data: List<Pair<String, String>>?) {
        requireNotNull(data)
        data.forEachIndexed { index, pair ->
            val (title, message) = pair

            spacing {
                id("$index")
                resource(R.dimen.space_1x)
            }

            largeTitle {
                id("$index")
                value("$index つ目")
            }

            spacing {
                id("$index")
                resource(R.dimen.space_1x)
            }

            settingItem {
                id(title) // 1つ1つのModelを区別するために異なるidを割り当てる必要がある
                title(title)
                message(message)
            }
        }
    }
}
