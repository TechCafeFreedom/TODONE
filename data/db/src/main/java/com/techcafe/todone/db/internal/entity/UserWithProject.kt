package com.techcafe.todone.db.internal.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Relation

data class UserWithProject(
    @Embedded
    val user: UserEntity,
    @Relation(parentColumn = "user_id",entityColumn = "author_id")
    val projects: List<ProjectEntity>
)