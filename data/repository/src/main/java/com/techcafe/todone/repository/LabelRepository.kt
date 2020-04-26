package com.techcafe.todone.repository

import techcafe.todone.Label

interface LabelRepository {
    suspend fun getProjectLabels(id: Int): List<Label>
}