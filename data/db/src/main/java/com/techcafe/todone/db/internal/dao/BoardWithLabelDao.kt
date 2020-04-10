package com.techcafe.todone.db.internal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techcafe.todone.db.internal.entity.BoardEntity
import com.techcafe.todone.db.internal.entity.LabelEntity
import com.techcafe.todone.db.internal.middleEntity.BoardWithLabel

@Dao
interface BoardWithLabelDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun bindLabel(boardWithLabel: BoardWithLabel)

    @Query(
        """
               SELECT * FROM label_item
               INNER JOIN board_with_label
               ON label_item.label_id=board_with_label.label_id_with
               WHERE board_with_label.board_id_with=:boardId
               """
    )
    fun getLabelsForproject(boardId: Int): List<LabelEntity>

    @Query(
        """
               SELECT * FROM board_item
               INNER JOIN board_with_label
               ON board_item.board_id=board_with_label.board_id_with
               WHERE board_with_label.label_id_with=:labelId
               """
    )
    fun getProjectsForLabel(labelId: Int): List<BoardEntity>
}
