package com.techcafe.todone.home

import com.airbnb.epoxy.TypedEpoxyController
import com.techcafe.todone.androidcomponent.spacing

class HomeController : TypedEpoxyController<List<Pair<String, String>>>() {
    override fun buildModels(data: List<Pair<String, String>>) {
        if (data.isEmpty()) {
            empty {
                id("empty")
            }
            return
        }

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
    //後に必要になりそうなViewの更新
    fun update(newData: List<Pair<String, String>>) {
        requestModelBuild()
    }

}
