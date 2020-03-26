package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.ProjectEntity
import com.techcafe.todone.db.internal.entity.UserEntity
import com.techcafe.todone.db.internal.middleEntity.UserWithProject

@Dao
interface UserEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg user: UserEntity)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProject(vararg project: ProjectEntity)

    @Transaction
    @Query("SELECT * FROM user_item")
    suspend fun getProjectUserList(): List<UserWithProject>
    @Transaction
    @Query("SELECT * FROM project_item WHERE author_id = :userId")
    suspend fun searchProjectList(userId: String): List<ProjectEntity>
}
