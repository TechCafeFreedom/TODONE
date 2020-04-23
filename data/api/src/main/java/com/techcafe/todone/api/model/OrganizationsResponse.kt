package com.techcafe.todone.api.model

data class OrganizationsResponse(
    val id: Int,
    val url: String,
    val members_url: String,
    val public_members_url: String,
    val collaborators: Int
)