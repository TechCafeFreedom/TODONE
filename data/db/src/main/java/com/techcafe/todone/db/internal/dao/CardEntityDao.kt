package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.CardEntity

@Dao
interface CardEntityDao {
    /**
     * @author felix925
     * @param card
     * @return Unit
     * @sample insertCard(card)
     * @see CardEntity
     * @throws none
     * @exception none
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(vararg card: CardEntity)

    /**
     * @author felix925
     * @param kanbanId
     * @return 看板に紐づくカードのリスト or EmptyList
     * @sample getBindTodoById(kanbanId)
     * @see CardEntity
     * @throws none
     * @exception none
     */
    @Transaction
    @Query("SELECT * FROM card_item WHERE parent_kanban_id = :kanbanId")
    suspend fun getBindTodoById(kanbanId: Int): List<CardEntity>

    /**
     * @author felix925
     * @param cardId
     * @return 引数と同じidかnull
     * @sample getTodoById(cardId)
     * @see CardEntity
     * @throws none
     * @exception none
     */
    @Transaction
    @Query("SELECT * FROM card_item WHERE card_id = :cardId LIMIT 1")
    suspend fun getTodoById(cardId: Int): CardEntity?
}
