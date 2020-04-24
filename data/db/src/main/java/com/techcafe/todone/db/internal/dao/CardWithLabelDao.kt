package com.techcafe.todone.db.internal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techcafe.todone.db.internal.entity.CardEntity
import com.techcafe.todone.db.internal.entity.LabelEntity
import com.techcafe.todone.db.internal.middleEntity.CardWithLabel

/**
 * カードとラベルに跨るデータのDao
 */
@Dao
interface CardWithLabelDao {
    /**
     * カードとラベルを紐づける関数
     *
     * @param [CardWithLabel] 登録したいカードとラベルのidを持つCardWithLabelインスタンス
     * @see CardWithLabel
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bindLabel(cardWithLabel: CardWithLabel)

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
}
