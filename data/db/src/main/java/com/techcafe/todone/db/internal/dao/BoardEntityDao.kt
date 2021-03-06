package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.BoardEntity
import com.techcafe.todone.db.internal.entity.UserEntity
import com.techcafe.todone.db.internal.middleEntity.UserWithBoard

/**
 * Boardに関するDao
 */
@Dao
interface BoardEntityDao {
    /**
     * ボードを挿入する関数
     *
     * @param [BoardEntity] 登録したいBordEntityインスタンス
     * @see BoardEntity
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBoard(vararg board: BoardEntity)

    /**
     * ボードを更新する関数
     *
     * @param [BoardEntity] 更新したいBordEntityインスタンス
     * @see BoardEntity
     */
    @Update
    fun updateBoard(vararg board: BoardEntity)

    /**
     * ユーザーとボードを紐づける関数
     *
     * @param [userWithBoard] 登録したいユーザーとボードのidを持つuserWithBoard
     * @see UserWithBoard
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun bindBoard(userWithBoard: UserWithBoard)

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
     * ボードに紐づいているユーザーを出力する関数
     *
     * @param [boardId] 紐づいているユーザーを取得したいボードのid
     * @see UserEntity
     * @see BoardEntity
     */
    @Transaction
    @Query(
        """
               SELECT * FROM user_item
               INNER JOIN user_with_board
               ON user_item.user_id=user_with_board.user_id_with
               WHERE user_with_board.board_id_with=:boardId
               """
    )
    suspend fun getBindUserList(vararg boardId: String): List<UserEntity>

    /**
     * ボードを全て削除する関数
     *
     * @see BoardEntity
     */
    @Query("DELETE FROM board_item")
    fun deleteAll()

    /**
     * 引数と同じidをもつboardを削除する関数
     *
     * @param [boardId] 削除したいボードのid
     * @see BoardEntity
     */
    @Query("DELETE FROM board_item WHERE board_id = :boardId")
    fun deleteBoard(boardId: Int)
}
