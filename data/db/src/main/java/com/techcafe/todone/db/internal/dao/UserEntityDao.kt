package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.BoardEntity
import com.techcafe.todone.db.internal.entity.LabelEntity
import com.techcafe.todone.db.internal.entity.UserEntity

/**
 * ユーザーに関するDao
 */
@Dao
interface UserEntityDao {
    /**
     * ユーザーを作成する関数
     *
     * @param [user] 登録したいユーザーのインスタンス
     * @see UserEntity
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg user: UserEntity)

    /**
     * ユーザーを更新する関数
     *
     * @param [UserEntity] 更新したいUserEntityインスタンス
     * @see UserEntity
     */
    @Update
    fun updateUser(vararg user: UserEntity)

    /**
     * 登録されているユーザーのリストを返す関数
     *
     * @see UserEntity
     */
    @Transaction
    @Query("SELECT * FROM user_item")
    suspend fun getUserList(): List<UserEntity>

    /**
     * 引数のidを持つユーザーを取得する関数
     *
     * @param [userId] 取得したいユーザーが持つid
     * @see UserEntity
     */
    @Transaction
    @Query("SELECT * FROM user_item WHERE user_id = :userId LIMIT 1")
    suspend fun getUserById(userId: String): UserEntity?

    /**
     * ユーザーを全部削除する関数
     *
     * @see UserEntity
     */
    @Query("DELETE FROM user_item")
    fun deleteAll()

    /**
     * 引数のidと一致するユーザーを削除
     *
     * @param [userId] 紐づいているカードを削除したいユーザーのid
     * @see UserEntity
     */
    @Query("DELETE FROM user_item WHERE user_id = :userId")
    fun deleteAllById(userId: Int)
}
