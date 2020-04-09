package com.techcafe.todone.db.internal.middleEntity

import com.techcafe.todone.db.internal.entity.ProjectEntity
import com.techcafe.todone.db.internal.entity.UserEntity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "user_with_project",
    primaryKeys = ["proj_id_with", "user_id_with"],
    foreignKeys = [
        ForeignKey(
            entity = ProjectEntity::class,
            parentColumns = ["project_id"],
            childColumns = ["proj_id_with"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id_with"],
            onDelete = ForeignKey.CASCADE
        )
    ]

)
data class UserWithProject(
    @ColumnInfo(name = "proj_id_with")
    val projectId: Int,
    @ColumnInfo(name = "user_id_with")
    val userId: String
)
