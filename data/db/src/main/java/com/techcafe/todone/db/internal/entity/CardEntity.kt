package com.techcafe.todone.db.internal.entity

import androidx.room.*
import com.techcafe.todone.db.internal.converter.DateTime

@Entity(tableName = "card_item",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = KanbanEntity::class,
            parentColumns = arrayOf("kanban_id"),
            childColumns = arrayOf("parent_kanban_id"),
            onDelete = ForeignKey.CASCADE // ユーザーが削除されると子も削除される(話し合う必要有り)
        )
    )
)
data class CardEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "card_id")
    val id: Int,
    @ColumnInfo(name = "parent_kanban_id")
    val kanbanId: Int,
    @ColumnInfo(name = "card_title")
    val title: String,
    @ColumnInfo(name = "card_desc")
    val description: String,
    @ColumnInfo(name = "card_deadline")
    val deadline: String,
    @ColumnInfo(name = "card_archive")
    val isArchive: Boolean
)
