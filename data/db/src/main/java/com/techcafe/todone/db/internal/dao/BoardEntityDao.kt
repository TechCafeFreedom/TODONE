package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.BoardEntity

/**
 * Boardに関するDao
 */
@Dao
interface BoardEntityDao {
    /**
     * プロジェクトを挿入する関数
     *
     * @param [BoardEntity] 登録したいBordEntityインスタンス
     * @see BoardEntity
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBoard(vararg board: BoardEntity)

    /**
     * 引数のidに該当するボードを削除する関数
     *
     * @param [boardId] 削除したいボードのid
     * @see BoardEntity
     */
    @Query("DELETE FROM board_item WHERE board_id = :boardId")
    fun deleteBoard(boardId: Int)

    /**
     * 引数のidに該当するボードを返す関数
     *
     * @param [boardId] 取得したいボードのid
     * @see BoardEntity
     */
    @Transaction
    @Query("SELECT * FROM board_item WHERE board_id = :boardId LIMIT 1")
    suspend fun getBoardById(boardId: Int): BoardEntity?

    /**
     * ユーザーに紐づいているボードを取得する関数
     *
     * @param [userId] 紐づいているボードを取得したいユーザーのid
     * @see BoardEntity
     */
    @Transaction
    @Query(
        """
               SELECT * FROM board_item
               INNER JOIN user_with_board
               ON board_item.board_id=user_with_board.board_id_with
               WHERE user_with_board.user_id_with=:userId
               """
    )
    suspend fun getBindBoardList(vararg userId: String): List<BoardEntity>

    /**
     * ユーザーに紐づいているボードを取得する関数
     *
     * @param [userId] 紐づいているボードを取得したいユーザーのid
     * @see BoardEntity
     */
    @Query("DELETE FROM board_item")
    fun deleteAll()
}
