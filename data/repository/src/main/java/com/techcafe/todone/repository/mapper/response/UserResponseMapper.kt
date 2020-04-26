package com.techcafe.todone.repository.mapper.response

import com.techcafe.todone.api.model.UserResponse
import techcafe.todone.User

fun UserResponse.toModel() = User(
    id = id,
    name = name,
    thumbnail = thumbnail
)
