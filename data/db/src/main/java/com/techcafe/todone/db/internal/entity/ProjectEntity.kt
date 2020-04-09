package com.techcafe.todone.db.internal.entity

import com.techcafe.todone.db.internal.converter.DateTime
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "project_item")
data class ProjectEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "project_id")
    val id: Int,
    @ColumnInfo(name = "project_title")
    val title: String,
    @ColumnInfo(name = "project_desc")
    val description: String,
    @ColumnInfo(name = "project_created")
    val projectCreatedAt: DateTime,
    @ColumnInfo(name = "project_updated")
    val projectUpdatedAt: DateTime
)
