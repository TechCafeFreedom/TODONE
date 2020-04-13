package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.CardEntity

/**
 * カードに関するDao
 */
@Dao
interface CardEntityDao {
    /**
     * カードを登録する関数
     *
     * @param [card] 登録したいカードインスタンス
     * @see CardEntity
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(vararg card: CardEntity)

    /**
     * 看板に紐づいているカードのリストを返す関数
     *
     * @param [kanbanId] 紐づいているカードのリストを取得したい看板のid
     * @see CardEntity
     */
    @Transaction
    @Query("SELECT * FROM card_item WHERE parent_kanban_id = :kanbanId")
    suspend fun getBindCardById(kanbanId: Int): List<CardEntity>

    /**
     * 引数のカードidと同じカードを返す関数
     *
     * @param [cardId] 同じidを持つデータを取得したい際のid
     * @see CardEntity
     */
    @Transaction
    @Query("SELECT * FROM card_item WHERE card_id = :cardId LIMIT 1")
    suspend fun getCardById(cardId: Int): CardEntity?
}
