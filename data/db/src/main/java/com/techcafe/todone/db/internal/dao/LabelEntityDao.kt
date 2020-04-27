package com.techcafe.todone.db.internal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techcafe.todone.db.internal.entity.LabelEntity

/**
 * ラベルに関するDao
 */
@Dao
interface LabelEntityDao {
    /**
     * ラベルを作成する関数
     *
     * @param [label] 登録したいラベルのインスタンス
     * @see LabelEntity
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLabel(label: LabelEntity)

    /**
     * ラベルのリストを取得する関数
     *
     * @see LabelEntity
     */
    @Query("SELECT * FROM label_item")
    fun getLabelList(): LiveData<List<LabelEntity>>
}
