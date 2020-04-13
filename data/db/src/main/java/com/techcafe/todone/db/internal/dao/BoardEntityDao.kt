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
     * 引数のidに該当するボードを返す関数
     *
     * @param [boardId] 取得したいボードのid
     * @see BoardEntity
     */
    @Transaction
    @Query("SELECT * FROM board_item WHERE board_id = :boardId LIMIT 1")
    suspend fun getBoardById(boardId: Int): BoardEntity?
}