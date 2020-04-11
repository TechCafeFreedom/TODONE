package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.BoardEntity
import com.techcafe.todone.db.internal.entity.UserEntity
import com.techcafe.todone.db.internal.middleEntity.UserWithBoard

@Dao
interface UserWithBoardDao {
    /**
     * @author felix925
     * @param userWithBoard
     * @return Unit
     * @sample bindProject(userWithBoard)
     * @see UserWithBoard
     * @throws none
     * @exception none
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun bindProject(userWithBoard: UserWithBoard)

    /**
     * @author felix925
     * @param boardId
     * @return ボードに紐付くユーザーのリスト
     * @sample getBindUserList(board.id)
     * @see UserEntity
     * @see BoardEntity
     * @throws none
     * @exception none
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
     * @author felix925
     * @param userId
     * @return ユーザーに紐づいているボードのリスト
     * @sample getBindBoardList(user.id)
     * @see BoardEntity
     * @throws none
     * @exception none
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