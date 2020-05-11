package com.example.usecase

import androidx.lifecycle.LiveData
import techcafe.todone.Label
import techcafe.todone.Results

interface GetLabelsUseCase {
    val labelList: LiveData<Results<List<Label>>>
    suspend fun getBoardLabels(id: Int)
}
