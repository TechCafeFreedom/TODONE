package com.techcafe.todone.repository.mapper.response

import com.techcafe.todone.api.model.LabelResponse
import techcafe.todone.Label
import techcafe.todone.LabelColor

internal fun LabelResponse.toModel() = Label(
    id = id,
    title = title,
    color = LabelColor.toLabelColor(color)
)