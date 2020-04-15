package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.BoardEntity
import com.techcafe.todone.db.internal.entity.UserEntity
import com.techcafe.todone.db.internal.middleEntity.UserWithBoard

/**
 * ユーザーとボードに跨るデータのDao
 */
@Dao
interface UserWithBoardDao {
    /**
     * ユーザーとプロジェクトを紐づける関数
     *
     * @param [userWithBoard] 登録したいユーザーとボードのidを持つuserWithBoard
     * @see UserWithBoard
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun bindBoard(userWithBoard: UserWithBoard)

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
}
