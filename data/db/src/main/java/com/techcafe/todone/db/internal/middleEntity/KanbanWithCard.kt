package com.techcafe.todone.db.internal.middleEntity

import androidx.room.Embedded
import androidx.room.Relation
import com.techcafe.todone.db.internal.entity.CardEntity
import com.techcafe.todone.db.internal.entity.KanbanEntity

data class KanbanWithCard(
    @Embedded
    val kanban: KanbanEntity,
    @Relation(parentColumn = "kanban_id", entityColumn = "parent_kanban_id")
    val cardList: List<CardEntity>
)
