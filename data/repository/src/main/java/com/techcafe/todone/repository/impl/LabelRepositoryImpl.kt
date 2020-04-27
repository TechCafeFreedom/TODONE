package com.techcafe.todone.repository.impl

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.map
import com.techcafe.todone.api.MockService
import com.techcafe.todone.db.internal.dao.LabelEntityDao
import com.techcafe.todone.repository.LabelRepository
import com.techcafe.todone.repository.mapper.entity.toModel
import com.techcafe.todone.repository.mapper.response.toModel

class LabelRepositoryImpl(
    private val service: MockService,
    private val labelDao: LabelEntityDao
) : LabelRepository {
    override val labelList = labelDao.getLabelList().map { list -> list.map { it.toModel() } }
    private val needRefresh = MediatorLiveData<Boolean>().apply {
        value = true
        addSource(labelList) { value = true }
    }

    override suspend fun getBoardLabels(id: Int) {
        if (needRefresh.value == true) {
            val newLabel = service.getLabels(id).map { it.toModel() }
            labelDao.insertLabel(newLabel.toEntity())
            needRefresh.value = false
        }
    }
}
