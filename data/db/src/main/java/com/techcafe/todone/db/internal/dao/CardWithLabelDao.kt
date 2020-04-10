package com.techcafe.todone.db.internal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techcafe.todone.db.internal.entity.CardEntity
import com.techcafe.todone.db.internal.entity.LabelEntity
import com.techcafe.todone.db.internal.middleEntity.CardWithLabel

@Dao
interface CardWithLabelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bindLabel(cardWithLabel: CardWithLabel)

    @Query(
        """
               SELECT * FROM label_item
               INNER JOIN card_with_label
               ON label_item.label_id=card_with_label.label_id_with
               WHERE card_with_label.card_id_with=:cardId
               """
    )
    fun getLabelsForTodo(cardId: Int): List<LabelEntity>

    @Query(
        """
               SELECT * FROM card_item
               INNER JOIN card_with_label
               ON card_item.card_id=card_with_label.card_id_with
               WHERE card_with_label.label_id_with=:labelId
               """
    )
    fun getTodosForLabel(labelId: Int): List<CardEntity>
}
