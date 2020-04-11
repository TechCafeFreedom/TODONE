package com.techcafe.todone.db.internal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techcafe.todone.db.internal.entity.LabelEntity

@Dao
interface LabelEntityDao {
    /**
     * @author felix925
     * @param label
     * @return Unit
     * @sample insertLabel
     * @see LabelEntity
     * @throws none
     * @exception none
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLabel(label: LabelEntity)

    /**
     * @author felix925
     * @param none
     * @return 登録されているラベルのリスト
     * @sample getLabelList()
     * @see LabelEntity
     * @throws none
     * @exception none
     */
    @Query("SELECT * FROM label_item")
    fun getLabelList(): List<LabelEntity>
}
