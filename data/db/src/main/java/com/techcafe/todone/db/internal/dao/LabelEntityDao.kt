package com.techcafe.todone.db.internal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techcafe.todone.db.internal.entity.LabelEntity

@Dao
interface LabelEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLabel(label: LabelEntity)

    @Query("SELECT * FROM label_item")
    fun getLabelList():List<LabelEntity>
}