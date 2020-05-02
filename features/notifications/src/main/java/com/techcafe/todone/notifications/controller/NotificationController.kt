package com.techcafe.todone.notifications.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.techcafe.todone.androidcomponent.R
import com.techcafe.todone.androidcomponent.spacing
import com.techcafe.todone.notifications.itemEmpty
import com.techcafe.todone.notifications.itemNotification
import com.techcafe.todone.notifications.model.SampleModel

class NotificationController : TypedEpoxyController<List<SampleModel>>() {
    override fun buildModels(data: List<SampleModel>) {
        if (data.isEmpty()) {
            itemEmpty {
                id("empty")
            }
            return
        }

        data.forEachIndexed { index, sampleModel ->
            val title = sampleModel.title
            val description = sampleModel.description

            spacing {
                id("$index")
                resource(R.dimen.space_1x)
            }

            itemNotification {
                id("$index")
                title(title)
                description(description)
            }
        }
    }
}
