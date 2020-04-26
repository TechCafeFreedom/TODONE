package com.techcafe.todone.repository.impl

import com.techcafe.todone.api.MockService
import com.techcafe.todone.db.internal.dao.LabelEntityDao
import com.techcafe.todone.repository.LabelRepository
import techcafe.todone.Label

class LabelRepositoryImpl(
    private val service: MockService,
    private val labelDao: LabelEntityDao
) : LabelRepository {
    override suspend fun getProjectLabels(id: Int): List<Label> {
        TODO("Not yet implemented")
    }
}