package com.techcafe.todone.db.internal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techcafe.todone.db.internal.entity.BoardEntity
import com.techcafe.todone.db.internal.entity.LabelEntity
import com.techcafe.todone.db.internal.middleEntity.BoardWithLabel

/**
 * ボードとラベルに跨るデータのDao
 */
@Dao
interface BoardWithLabelDao {
    /**
     * ボードとラベルを結びつける関数
     *
     * @param [BoardWithLabel] 登録したいボードとラベルのidを持つBoardWithLabelEntity
     * @see BoardWithLabel
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun bindLabel(boardWithLabel: BoardWithLabel)

    /**
     * ボードに紐づいているラベルのリストを取得する関数
     *
     * @param [boardId] ラベル一覧を取得したいボードのid
     * @see [BoardEntity]
     * @see [LabelEntity]
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
     * ラベルに紐づいているボードを出力する関数
     *
     * @param [labelId] ボード一覧を取得したいラベルのid
     * @see [BoardEntity]
     * @see [LabelEntity]
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
