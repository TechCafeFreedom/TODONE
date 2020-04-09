package com.techcafe.todone.db.internal.middleEntity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.techcafe.todone.db.internal.entity.LabelEntity
import com.techcafe.todone.db.internal.entity.TodoEntity

@Entity(
    tableName = "todo_with_label",
    primaryKeys = ["todo_id_with", "label_id_with"],
    foreignKeys = [
        ForeignKey(
            entity = TodoEntity::class,
            parentColumns = ["todo_id"],
            childColumns = ["todo_id_with"],
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
data class TodoWithLabel(
    @ColumnInfo(name = "todo_id_with")
    val todoId: Int,
    @ColumnInfo(name = "label_id_with")
    val labelId: Int
)
