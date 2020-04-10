package com.techcafe.todone.db.internal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kanban_item")
data class KanbanEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "label_id")
    val id: Int,
    @ColumnInfo(name = "label_title")
    val title: String,
    @ColumnInfo(name = "label_desc")
    val description: String
)