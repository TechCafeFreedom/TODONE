package com.techcafe.todone.home

import com.airbnb.epoxy.TypedEpoxyController
import com.techcafe.todone.androidcomponent.spacing

class HomeController : TypedEpoxyController<List<Pair<String, String>>>() {
    override fun buildModels(data: List<Pair<String, String>>?) {
        requireNotNull(data)
        data.forEachIndexed { index, pair ->
            val (projectName, description) = pair

            spacing {
                id("$index")
                resource(R.dimen.space_1x)
            }

            item {
                id(projectName)
                projectName(projectName)
                description(description)
            }

        }
    }
}
