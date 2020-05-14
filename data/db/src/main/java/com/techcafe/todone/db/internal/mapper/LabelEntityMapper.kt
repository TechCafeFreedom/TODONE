package com.techcafe.todone.db.internal.mapper

import com.techcafe.todone.db.internal.entity.LabelEntity
import techcafe.todone.Label

fun LabelEntity.toModel() = Label(
    id = id,
    title = title,
    color = color
)

fun Label.toEntity(boardId: Int) = LabelEntity(
    id = id,
    boardId = boardId,
    title = title,
    color = color
)