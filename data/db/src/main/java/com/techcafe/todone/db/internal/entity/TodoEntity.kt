package com.techcafe.todone.db.internal.entity

import androidx.room.ColumnInfo
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation

//@Entity(tableName = "todo_item")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todo_id")
    val id: String,
    @ColumnInfo(name = "todo_title")
    val title: String,
    @ColumnInfo(name = "todo_content")
    val content: String,
    @ColumnInfo(name = "todo_deadline")
    val deadline: String,
    @ColumnInfo(name = "todo_state")
    val state: String,
    @ColumnInfo(name = "todo_createdAt")
    val createdAt: String,
    @ColumnInfo(name = "todo_updatedAt")
    val updatedAt: String,
    @Relation(
        entity = LabelEntity::class,
        parentColumn = "todo_id",
        entityColumn = "label_id",
        associateBy = Junction(
            value = ProjectWithLabel::class,
            parentColumn = "todo_withid",
            entityColumn = "label_withid"
        )
    )
    val label:List<LabelEntity>
)