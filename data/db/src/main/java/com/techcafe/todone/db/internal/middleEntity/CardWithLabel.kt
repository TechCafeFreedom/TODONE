package com.techcafe.todone.db.internal.middleEntity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.techcafe.todone.db.internal.entity.CardEntity
import com.techcafe.todone.db.internal.entity.LabelEntity

@Entity(
    tableName = "card_with_label",
    primaryKeys = ["card_id_with", "label_id_with"],
    foreignKeys = [
        ForeignKey(
            entity = CardEntity::class,
            parentColumns = ["card_id"],
            childColumns = ["card_id_with"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = LabelEntity::class,
            parentColumns = ["label_id"],
            childColumns = ["label_id_with"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CardWithLabel(
    @ColumnInfo(name = "card_id_with")
    val cardId: Int,
    @ColumnInfo(name = "label_id_with")
    val labelId: Int
)
