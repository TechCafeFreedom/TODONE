package com.techcafe.todone.db.internal.entity

import com.techcafe.todone.db.internal.converter.DateTime
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "board_item")
data class BoardEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "board_id")
    val id: Int,
    @ColumnInfo(name = "board_title")
    val title: String,
    @ColumnInfo(name = "board_desc")
    val description: String,
    @ColumnInfo(name = "board_archive")
    val isArchive: Boolean
)
