package com.techcafe.todone.db.internal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kanban_item")
data class KanbanEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "kanban_id")
    val id: Int,
    @ColumnInfo(name = "kanban_title")
    val title: String,
    @ColumnInfo(name = "kanban_desc")
    val description: String
)