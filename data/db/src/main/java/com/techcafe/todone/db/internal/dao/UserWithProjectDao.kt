package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.ProjectEntity
import com.techcafe.todone.db.internal.entity.UserEntity
import com.techcafe.todone.db.internal.middleEntity.UserWithProject

@Dao
interface UserWithProjectDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun bindProject(userWithProject: UserWithProject)

    @Transaction
    @Query("""
               SELECT * FROM user_item
               INNER JOIN user_with_project
               ON user_item.user_id=user_with_project.user_id_with
               WHERE user_with_project.proj_id_with=:projId
               """)
    suspend fun getBindUserList(vararg projId: String): List<UserEntity>

    @Transaction
    @Query("""
               SELECT * FROM project_item
               INNER JOIN user_with_project
               ON project_item.project_id=user_with_project.proj_id_with
               WHERE user_with_project.user_id_with=:userId
               """)
    suspend fun getBindProjList(vararg userId: String): List<ProjectEntity>
}