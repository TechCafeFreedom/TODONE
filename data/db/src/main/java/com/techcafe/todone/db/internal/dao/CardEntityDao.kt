package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.BoardEntity
import com.techcafe.todone.db.internal.entity.CardEntity
import com.techcafe.todone.db.internal.entity.LabelEntity
import com.techcafe.todone.db.internal.middleEntity.CardWithLabel

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
     * カードとラベルを紐づける関数
     *
     * @param [CardWithLabel] 登録したいカードとラベルのidを持つCardWithLabelインスタンス
     * @see CardWithLabel
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bindLabel(cardWithLabel: CardWithLabel)

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

    /**
     * カードに紐づいているラベルを取得する関数
     *
     * @param [cardId] 紐付くラベル一覧を取得したいカードのid
     * @see LabelEntity
     * @see CardWithLabel
     */
    @Query(
        """
               SELECT * FROM label_item
               INNER JOIN card_with_label
               ON label_item.label_id=card_with_label.label_id_with
               WHERE card_with_label.card_id_with=:cardId
               """
    )
    fun getLabelsForCard(cardId: Int): List<LabelEntity>

    /**
     * カードを全て削除する関数
     *
     * @param [kanbanId] 紐づいているカードを削除したいボードのid
     * @see BoardEntity
     */
    @Query("DELETE FROM card_item")
    fun deleteAll()

    /**
     * 引数のカンバンに紐づくカードを全て削除する関数
     *
     * @param [kanbanId] 紐づいているカードを削除したいカンバンのid
     * @see KanbanEntity
     */
    @Query("DELETE FROM card_item WHERE parent_kanban_id = :kanbanId")
    fun deleteAllById(kanbanId: Int)

    /**
     * ユーザーに紐づいているボードを取得する関数
     *
     * @param [kanbanId] 紐づいているカードを削除したいボードのid
     * @see BoardEntity
     */
    @Query("DELETE FROM board_item WHERE board_id = :boardId")
    fun deleteBoard(boardId: Int)
}
