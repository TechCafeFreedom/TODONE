package com.techcafe.todone.db.internal.entity

import androidx.room.*
import com.techcafe.todone.db.internal.converter.DateTime

@Entity(tableName = "project_item",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = arrayOf("user_id"),
            childColumns = arrayOf("author_id"),
            onDelete = ForeignKey.CASCADE // ユーザーが削除されると子も削除される(話し合う必要有り)
    ))
)
data class ProjectEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "project_id")
    val id: Int,
    @ColumnInfo(name = "author_id")
    val author: String,
    @ColumnInfo(name = "project_title")
    val title: String,
    @ColumnInfo(name = "project_desc")
    val description: String,
    @ColumnInfo(name = "project_created")
    val projectCreatedAt: DateTime,
    @ColumnInfo(name = "project_updated")
    val projectUpdatedAt: DateTime
)
