package com.techcafe.todone.api.model

data class BoardResponse(
    val id: Int,
    val title: String,
    val description: String,
    val author: UserResponse,
    val members: List<UserResponse>,
    val kanbans: List<KanbanResponse>,
    val labels: List<LabelResponse>,
    val is_archive: Boolean
)
