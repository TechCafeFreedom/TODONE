package com.techcafe.todone.repository.mapper.entity

import com.techcafe.todone.db.internal.entity.LabelEntity
import techcafe.todone.Label

internal fun LabelEntity.toModel() = Label(
    id = id,
    title = title,
    color = color
)