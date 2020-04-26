package com.techcafe.todone.api.model

data class LabelResponse(
    val id: Int,
    val name: String,
    val description: String,
    val color: Int
)