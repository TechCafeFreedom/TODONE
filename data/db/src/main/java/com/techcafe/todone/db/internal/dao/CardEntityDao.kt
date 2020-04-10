package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.CardEntity

@Dao
interface CardEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(vararg card: CardEntity)

    @Transaction
    @Query("SELECT * FROM card_item WHERE parent_kanban_id = :kanbanId")
    suspend fun getBindTodoById(kanbanId: Int): List<CardEntity>

    @Transaction
    @Query("SELECT * FROM card_item WHERE card_id = :cardId LIMIT 1")
    suspend fun getTodoById(cardId: Int): CardEntity?
}
