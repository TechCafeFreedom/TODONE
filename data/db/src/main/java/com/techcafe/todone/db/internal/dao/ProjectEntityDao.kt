package com.techcafe.todone.db.internal.dao

import androidx.room.*
import com.techcafe.todone.db.internal.entity.ProjectEntity
import com.techcafe.todone.db.internal.middleEntity.TodoWithLabel
import com.techcafe.todone.db.internal.middleEntity.UserWithProject

@Dao
interface ProjectEntityDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProject(vararg project: ProjectEntity)

    @Transaction
    @Query("SELECT * FROM project_item WHERE project_id = :projectId LIMIT 1")
    suspend fun getProjectById(projectId: Int): ProjectEntity?
}