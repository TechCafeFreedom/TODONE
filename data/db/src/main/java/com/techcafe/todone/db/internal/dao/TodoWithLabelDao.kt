package com.techcafe.todone.db.internal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techcafe.todone.db.internal.entity.LabelEntity
import com.techcafe.todone.db.internal.entity.TodoEntity
import com.techcafe.todone.db.internal.entity.TodoWithLabel

@Dao
interface TodoWithLabelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bindLabel(todoWithLabel: TodoWithLabel)

    @Query("""
               SELECT * FROM label_item
               INNER JOIN todo_with_label
               ON label_item.label_id=todo_with_label.label_id_with
               WHERE todo_with_label.todo_id_with=:todoId
               """)
    fun getLabelsForTodo(todoId: Int): List<LabelEntity>

    @Query("""
               SELECT * FROM todo_item
               INNER JOIN todo_with_label
               ON todo_item.todo_id=todo_with_label.todo_id_with
               WHERE todo_with_label.label_id_with=:labelId
               """)
    fun getTodosForLabel(labelId: Int): List<TodoEntity>
}