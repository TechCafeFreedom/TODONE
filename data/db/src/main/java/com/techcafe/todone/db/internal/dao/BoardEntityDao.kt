package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.BoardEntity

@Dao
interface BoardEntityDao {
    /**
     * @author felix925
     * @param BoardEntity
     * @return Unit
     * @sample insertProject(board)
     * @see BoardEntity
     * @throws none
     * @exception none
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProject(vararg board: BoardEntity)

    /**
     * @author felix925
     * @param ボードのid
     * @return BoardEntity?
     * @sample getBoardById(board.id)
     * @see BoardEntity
     * @throws none
     * @exception none
     */
    @Transaction
    @Query("SELECT * FROM board_item WHERE board_id = :boardId LIMIT 1")
    suspend fun getBoardById(boardId: Int): BoardEntity?
}