package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.TodoEntity
import com.techcafe.todone.db.internal.middleEntity.ProjectWithTodo

@Dao
interface ProjectEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(vararg todo: TodoEntity)

    @Transaction
    @Query("SELECT * FROM project_item")
    fun getProjectTodoList(): List<ProjectWithTodo>
    @Transaction
    @Query("SELECT * FROM todo_item WHERE parent_project_id = :projectId")
    fun searchTodoList(projectId: String): List<TodoEntity>
}
