package com.techcafe.todone.db.internal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techcafe.todone.db.internal.entity.LabelEntity
import com.techcafe.todone.db.internal.entity.ProjectEntity
import com.techcafe.todone.db.internal.entity.ProjectWithLabel

@Dao
interface ProjectWithLabelDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun bindLabel(projectWithLabel: ProjectWithLabel)

    @Query("""
               SELECT * FROM label_item
               INNER JOIN project_with_label
               ON label_item.label_id=project_with_label.label_id_with
               WHERE project_with_label.proj_id_with=:projectId
               """)
    fun getLabelsForproject(projectId: Int): List<LabelEntity>

    @Query("""
               SELECT * FROM project_item
               INNER JOIN project_with_label
               ON project_item.project_id=project_with_label.proj_id_with
               WHERE project_with_label.label_id_with=:labelId
               """)
    fun getProjectsForLabel(labelId: Int): List<ProjectEntity>
}
