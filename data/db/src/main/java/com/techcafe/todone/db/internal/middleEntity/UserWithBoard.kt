package com.techcafe.todone.db.internal.middleEntity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import com.techcafe.todone.db.internal.entity.BoardEntity
import com.techcafe.todone.db.internal.entity.UserEntity

@Entity(
    tableName = "user_with_board",
    primaryKeys = ["board_id_with", "user_id_with"],
    foreignKeys = [
        ForeignKey(
            entity = BoardEntity::class,
            parentColumns = ["board_id"],
            childColumns = ["board_id_with"],
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
data class UserWithBoard(
    @ColumnInfo(name = "board_id_with")
    val boardId: Int,
    @ColumnInfo(name = "user_id_with")
    val userId: String
)
