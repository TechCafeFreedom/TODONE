package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.BoardEntity

@Dao
interface BoardEntityDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProject(vararg board: BoardEntity)

    @Transaction
    @Query("SELECT * FROM board_item WHERE board_id = :boardId LIMIT 1")
    suspend fun getProjectById(boardId: Int): BoardEntity?
}