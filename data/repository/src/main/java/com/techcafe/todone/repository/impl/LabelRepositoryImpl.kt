package com.techcafe.todone.repository.impl

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.map
import com.techcafe.todone.api.MockService
import com.techcafe.todone.db.internal.dao.LabelEntityDao
import com.techcafe.todone.db.internal.mapper.toEntity
import com.techcafe.todone.repository.LabelRepository
import com.techcafe.todone.repository.mapper.entity.toModel
import com.techcafe.todone.repository.mapper.response.toModel

class LabelRepositoryImpl(
    private val service: MockService,
    private val labelDao: LabelEntityDao
) : LabelRepository {
    override val labelList = labelDao.getLabelList().map { list -> list.map { it.toModel() } }

    // ローカルで更新が走ったらfetchフラグをtrueに
    private val needRefresh = MediatorLiveData<Boolean>().apply {
        value = true
        addSource(labelList) { value = true }
    }

    override suspend fun getBoardLabels(id: Int) {
        if (needRefresh.value == true) {
            val newLabel = service.getLabels(id).map { it.toModel() }
            // TODO: Labelを複数登録するDaoが必要そう 現状はひとつずつinsert
            newLabel.map { it.toEntity(id) }.forEach {
                labelDao.insertLabel(it)
            }
            needRefresh.value = false
        }
    }
}
