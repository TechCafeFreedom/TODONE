package com.techcafe.todone.db.internal.middleEntity

import androidx.room.Embedded
import androidx.room.Relation
import com.techcafe.todone.db.internal.entity.ProjectEntity
import com.techcafe.todone.db.internal.entity.TodoEntity

data class ProjectWithTodo(
    @Embedded
    val project: ProjectEntity,
    @Relation(parentColumn = "project_id", entityColumn = "parent_project_id")
    val todoList: List<TodoEntity>
)
