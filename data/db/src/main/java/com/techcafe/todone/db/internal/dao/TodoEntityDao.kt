package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.TodoEntity

@Dao
interface TodoEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(vararg todo: TodoEntity)

    @Transaction
    @Query("SELECT * FROM todo_item WHERE parent_project_id = :projectId")
    suspend fun getBindTodoById(projectId: Int): List<TodoEntity>

    @Transaction
    @Query("SELECT * FROM todo_item WHERE todo_id = :todoId LIMIT 1")
    suspend fun getTodoById(todoId: Int): TodoEntity?
}
