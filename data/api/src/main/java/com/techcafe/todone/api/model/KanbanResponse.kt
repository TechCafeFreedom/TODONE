package com.techcafe.todone.api.model

data class KanbanResponse(
    val id: Int,
    val name: String,
    val author: UserResponse,
    val cards: List<CardResponse>,
    val is_archive: Boolean
)