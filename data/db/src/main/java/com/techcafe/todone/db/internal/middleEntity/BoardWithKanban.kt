package com.techcafe.todone.db.internal.middleEntity

import androidx.room.Embedded
import androidx.room.Relation
import com.techcafe.todone.db.internal.entity.BoardEntity
import com.techcafe.todone.db.internal.entity.KanbanEntity

data class BoardWithKanban(
    @Embedded
    val board: BoardEntity,
    @Relation(parentColumn = "board_id", entityColumn = "parent_board_id")
    val kanbanList: List<KanbanEntity>
)
//TEST PRE PUSH