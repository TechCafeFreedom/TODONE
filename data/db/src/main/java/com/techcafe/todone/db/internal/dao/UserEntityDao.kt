package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.UserEntity

@Dao
interface UserEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg user: UserEntity)

    @Transaction
    @Query("SELECT * FROM user_item")
    suspend fun getUserList(): List<UserEntity>

    @Transaction
    @Query("SELECT * FROM user_item WHERE user_id = :userId LIMIT 1")
    suspend fun getUserById(userId: String): UserEntity?
}
