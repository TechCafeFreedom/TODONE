package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.BoardEntity
import com.techcafe.todone.db.internal.entity.UserEntity
import com.techcafe.todone.db.internal.middleEntity.UserWithBoard

@Dao
interface UserWithBoardDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun bindProject(userWithBoard: UserWithBoard)

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

    @Transaction
    @Query(
        """
               SELECT * FROM board_item
               INNER JOIN user_with_board
               ON board_item.board_id=user_with_board.board_id_with
               WHERE user_with_board.user_id_with=:userId
               """
    )
    suspend fun getBindProjList(vararg userId: String): List<BoardEntity>
}