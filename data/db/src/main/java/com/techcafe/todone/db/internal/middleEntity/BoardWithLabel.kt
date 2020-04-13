package com.techcafe.todone.db.internal.middleEntity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.techcafe.todone.db.internal.entity.BoardEntity
import com.techcafe.todone.db.internal.entity.LabelEntity

@Entity(
    tableName = "board_with_label",
    primaryKeys = ["board_id_with", "label_id_with"],
    foreignKeys = [
        ForeignKey(
            entity = BoardEntity::class,
            parentColumns = ["board_id"],
            childColumns = ["board_id_with"],
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
data class BoardWithLabel(
    @ColumnInfo(name = "board_id_with")
    val boardId: Int,
    @ColumnInfo(name = "label_id_with")
    val labelId: Int
)
