package com.techcafe.todone.db.internal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "label_item",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = BoardEntity::class,
            parentColumns = arrayOf("board_id"),
            childColumns = arrayOf("parent_board_id"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class LabelEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "label_id")
    val id: Int,
    @ColumnInfo(name = "parent_board_id")
    val boardId: Int,
    @ColumnInfo(name = "label_title")
    val title: String,
    @ColumnInfo(name = "label_color")
    val color: Int
)
