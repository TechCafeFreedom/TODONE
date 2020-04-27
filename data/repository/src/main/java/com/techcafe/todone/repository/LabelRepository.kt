package com.techcafe.todone.repository

import androidx.lifecycle.LiveData
import techcafe.todone.Label

interface LabelRepository {
    val labelList: LiveData<List<Label>>
    suspend fun getBoardLabels(id: Int)
}