package com.techcafe.todone.api.model

data class CardResponse(
    val id: Int,
    val title: String,
    val content: String,
    val deadline: Int,
    val author: UserResponse,
    val labels: List<LabelResponse>,
    val created_at: Int,
    val is_archive: Boolean,
    val updated_at: Int
)