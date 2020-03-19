package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.ProjectEntity
import com.techcafe.todone.db.internal.entity.TodoEntity
import com.techcafe.todone.db.internal.entity.UserEntity
import com.techcafe.todone.db.internal.middleEntity.ProjectWithTodo
import com.techcafe.todone.db.internal.middleEntity.UserWithProject

@Dao
interface ProjectEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(vararg todo: TodoEntity)
    @Transaction
    @Query("SELECT * FROM project_item")
    fun getAllTodo():List<ProjectWithTodo>
    @Transaction
    @Query("SELECT * FROM todo_item WHERE parent_project_id = :projectId")
    fun getTodoList(projectId: String): List<TodoEntity>
}