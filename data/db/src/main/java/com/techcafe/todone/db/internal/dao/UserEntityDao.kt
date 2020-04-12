package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.UserEntity

@Dao
interface UserEntityDao {
    /**
     * @author felix925
     * @param user
     * @return Unit
     * @sample insertUser(user)
     * @see UserEntity
     * @throws none
     * @exception none
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg user: UserEntity)

    /**
     * @author felix925
     * @param
     * @return 登録されているユーザーのリスト
     * @sample getUserList()
     * @see UserEntity
     * @throws none
     * @exception none
     */
    @Transaction
    @Query("SELECT * FROM user_item")
    suspend fun getUserList(): List<UserEntity>

    /**
     * @author felix925
     * @param userId
     * @return userIdと同じidを持つUser or null
     * @sample getUserById(user.id)
     * @see UserEntity
     * @throws none
     * @exception none
     */
    @Transaction
    @Query("SELECT * FROM user_item WHERE user_id = :userId LIMIT 1")
    suspend fun getUserById(userId: String): UserEntity?
}