package com.techcafe.todone.db.internal.entity

import androidx.room.*

data class ProjectEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "project_id")
    val id:String,
    @ColumnInfo(name = "project_title")
    val title: String,
    @ColumnInfo(name = "project_desc")
    val description: String,
    @ColumnInfo(name = "project_created")
    val createdAt: DateTime,
    @ColumnInfo(name = "project_updated")
    val updatedAt: DateTime,
    @Embedded
    val todo: List<TodoEntity>,
    @Relation(
        entity = LabelEntity::class,
        parentColumn = "project_id",
        entityColumn = "label_id",
        associateBy = Junction(
            value = ProjectWithLabel::class,
            parentColumn = "project_withid",
            entityColumn = "label_withid"
        )
    )
    val label:List<LabelEntity>
)