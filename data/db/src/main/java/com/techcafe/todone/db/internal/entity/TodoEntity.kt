package com.techcafe.todone.db.internal.entity

import androidx.room.*
import com.techcafe.todone.db.internal.converter.DateTime

@Entity(tableName = "todo_item",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = ProjectEntity::class,
            parentColumns = arrayOf("project_id"),
            childColumns = arrayOf("parent_project_id"),
            onDelete = ForeignKey.CASCADE // ユーザーが削除されると子も削除される(話し合う必要有り)
        )
    )
)
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todo_id")
    val id: Int,
    @ColumnInfo(name = "parent_project_id")
    val projectId: Int,
    @ColumnInfo(name = "todo_title")
    val title: String,
    @ColumnInfo(name = "todo_content")
    val content: String,
    @ColumnInfo(name = "todo_deadline")
    val deadline: String,
    @ColumnInfo(name = "todo_state")
    val state: String,
    @ColumnInfo(name = "todo_createdAt")
    val createdAt: DateTime,
    @ColumnInfo(name = "todo_updatedAt")
    val updatedAt: DateTime
)
