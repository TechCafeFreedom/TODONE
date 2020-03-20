package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.ProjectEntity
import com.techcafe.todone.db.internal.entity.TodoEntity
import com.techcafe.todone.db.internal.entity.UserEntity
import com.techcafe.todone.db.internal.middleEntity.UserWithProject

@Dao
interface UserEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg user: UserEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProject(vararg project:ProjectEntity)
    @Transaction
    @Query("SELECT * FROM user_item")
    fun getAllUser():List<UserWithProject>
}