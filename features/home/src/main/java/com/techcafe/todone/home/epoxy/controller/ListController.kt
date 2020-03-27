package com.techcafe.todone.home.epoxy.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.techcafe.todone.home.model.Project

class ListController : TypedEpoxyController<List<Project>>() {

    override fun buildModels(data: List<Project>) {
    }
}
