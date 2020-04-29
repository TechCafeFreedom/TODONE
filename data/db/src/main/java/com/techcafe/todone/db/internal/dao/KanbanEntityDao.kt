package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.KanbanEntity

/**
 * カンバンに関するDao
 */
@Dao
interface KanbanEntityDao {
    /**
     * カンバンを作成する関数
     *
     * @param [Kanban] 登録したいカンバンのインスタンス
     * @see KanbanEntity
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKanban(vararg kanban: KanbanEntity)

    /**
     * カンバンを更新する関数
     *
     * @param [KanbanEntity] 更新したいKanbanEntityインスタンス
     * @see KanbanEntity
     */
    @Update
    fun updateKanban(vararg kanban: KanbanEntity)

    /**
     * 登録されているカンバンのリストを返す関数
     *
     * @see KanbanEntity
     */
    @Transaction
    @Query("SELECT * FROM kanban_item")
    suspend fun getKanbanList(): List<KanbanEntity>

    /**
     * 引数のidを持つカンバンを取得する関数
     *
     * @param [KanbanId] 取得したいカンバンが持つid
     * @see KanbanEntity
     */
    @Transaction
    @Query("SELECT * FROM kanban_item WHERE kanban_id = :kanbanId LIMIT 1")
    suspend fun getKanbanById(kanbanId: String): KanbanEntity?

    /**
     * カンバンを全部削除する関数
     *
     * @see KanbanEntity
     */
    @Query("DELETE FROM kanban_item")
    fun deleteAll()

    /**
     * 引数のidと一致するカンバンを削除
     *
     * @param [KanbanId] 紐づいているカードを削除したいカンバンのid
     * @see KanbanEntity
     */
    @Query("DELETE FROM kanban_item WHERE kanban_id = :kanbanId")
    fun deleteAllById(kanbanId: Int)
}
