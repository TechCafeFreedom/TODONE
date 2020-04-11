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
    /**
     * @author felix925
     * @param BoardWithLabel
     * @return Unit
     * @sample bindLabel(boardWithLabel)
     * @see BoardWithLabel
     * @throws none
     * @exception none
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun bindLabel(boardWithLabel: BoardWithLabel)

    /**
     * @author felix925
     * @param boardId
     * @return ボードに紐づいているラベルのリスト
     * @sample getLabelsForBoard(board.id)
     * @see BoardEntity
     * @see LabelEntity
     * @throws none
     * @exception none
     */
    @Query(
        """
               SELECT * FROM label_item
               INNER JOIN board_with_label
               ON label_item.label_id=board_with_label.label_id_with
               WHERE board_with_label.board_id_with=:boardId
               """
    )
    fun getLabelsForBoard(boardId: Int): List<LabelEntity>

    /**
     * @author felix925
     * @param labelId
     * @return ラベルに紐づいているボードのリスト
     * @sample getBoardsForLabel(label.id)
     * @see BoardEntity
     * @see LabelEntity
     * @throws none
     * @exception none
     */
    @Query(
        """
               SELECT * FROM board_item
               INNER JOIN board_with_label
               ON board_item.board_id=board_with_label.board_id_with
               WHERE board_with_label.label_id_with=:labelId
               """
    )
    fun getBoardsForLabel(labelId: Int): List<BoardEntity>
}
