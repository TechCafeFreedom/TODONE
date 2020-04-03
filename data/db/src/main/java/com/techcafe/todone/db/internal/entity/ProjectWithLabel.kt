package com.techcafe.todone.db.internal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
@Entity(
    tableName = "project_with_label",
    primaryKeys = ["proj_id_with", "label_id_with"],
    foreignKeys = [
        ForeignKey(
            entity = ProjectEntity::class,
            parentColumns = ["project_id"],
            childColumns = ["proj_id_with"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = LabelEntity::class,
            parentColumns = ["label_id"],
            childColumns = ["label_id_with"],
            onDelete = ForeignKey.CASCADE
        )
    ]

)
data class ProjectWithLabel(
    @ColumnInfo(name = "proj_id_with")
    val projectId: Int,
    @ColumnInfo(name = "label_id_with")
    val labelId: Int
)
