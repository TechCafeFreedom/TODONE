package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.CardEntity
import com.techcafe.todone.db.internal.entity.LabelEntity
import com.techcafe.todone.db.internal.middleEntity.CardWithLabel

/**
 * ラベルに関するDao
 */
@Dao
interface LabelEntityDao {
    /**
     * ラベルを作成する関数
     *
     * @param [label] 登録したいラベルのインスタンス
     * @see LabelEntity
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLabel(label: LabelEntity)

    /**
     * ラベルを更新する関数
     *
     * @param [LabelEntity] 更新したいLabelEntityインスタンス
     * @see LabelEntity
     */
    @Update
    fun updateLabel(vararg label: LabelEntity)

    /**
     * ラベルのリストを取得する関数
     *
     * @see LabelEntity
     */
    @Query("SELECT * FROM label_item")
    fun getLabelList(): List<LabelEntity>

    /**
     * ラベルに紐付くカードのリストを取得する関数
     *
     * @param [labelId] 紐付くカード一覧を取得したいラベルのid
     * @see CardEntity
     * @see CardWithLabel
     */
    @Query(
        """
               SELECT * FROM card_item
               INNER JOIN card_with_label
               ON card_item.card_id=card_with_label.card_id_with
               WHERE card_with_label.label_id_with=:labelId
               """
    )
    fun getCardsForLabel(labelId: Int): List<CardEntity>

    /**
     * ラベルを全部削除する関数
     *
     * @see LabelEntity
     */
    @Query("DELETE FROM label_item")
    fun deleteAll()

    /**
     * 引数のidと一致するラベルを削除
     *
     * @param [labelId] 紐づいているカードを削除したいラベルのid
     * @see LabelEntity
     */
    @Query("DELETE FROM label_item WHERE label_id = :labelId")
    fun deleteAllById(labelId: Int)
}
