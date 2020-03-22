package com.techcafe.todone.db.internal.middleEntity

import androidx.room.Embedded
import androidx.room.Relation
import com.techcafe.todone.db.internal.entity.ProjectEntity
import com.techcafe.todone.db.internal.entity.UserEntity

data class UserWithProject(
    @Embedded
    val user: UserEntity,
    @Relation(parentColumn = "user_id", entityColumn = "author_id", entity = ProjectEntity::class)
    val projectsAndTodo: List<ProjectWithTodo>
)
