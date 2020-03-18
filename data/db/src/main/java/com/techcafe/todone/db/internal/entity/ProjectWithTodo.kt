package com.techcafe.todone.db.internal.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ProjectWithTodo(
    @Embedded
    val project: ProjectEntity,
    @Relation(parentColumn = "project_id",entityColumn = "parent_project_id")
    val todoList: List<TodoEntity>
)