package com.techcafe.todone.db.internal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_item")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    val id: String,
    @ColumnInfo(name = "user_name")
    val name: String,
    @ColumnInfo(name = "user_thumbnail")
    val thumbnail: String
)
