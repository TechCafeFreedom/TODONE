package com.techcafe.todone.db.internal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "kanban_item",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = BoardEntity::class,
            parentColumns = arrayOf("board_id"),
            childColumns = arrayOf("parent_board_id"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class KanbanEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "kanban_id")
    val id: Int,
    @ColumnInfo(name = "parent_board_id")
    val projectId:Int,
    @ColumnInfo(name = "kanban_title")
    val title: String,
    @ColumnInfo(name = "kanban_desc")
    val description: String
)