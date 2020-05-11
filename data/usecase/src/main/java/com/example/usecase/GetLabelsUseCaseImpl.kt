package com.example.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.techcafe.todone.repository.LabelRepository
import techcafe.todone.Label
import techcafe.todone.Results

class GetLabelsUseCaseImpl(
    private val repository: LabelRepository
) : GetLabelsUseCase {
    private val _labelList: MutableLiveData<Results<List<Label>>> = MediatorLiveData<Results<List<Label>>>().apply {
        addSource(repository.labelList) { value = Results.Success(it) }
    }
    override val labelList: LiveData<Results<List<Label>>> get() = _labelList

    override suspend fun getBoardLabels(id: Int) {
        val oldValue = labelList.value
        val value = if (oldValue is Results.Success) oldValue.data else null
        _labelList.value = Results.Loading(value)
        val results = Results { repository.getBoardLabels(id) }
        if (results is Results.Failure) {
            _labelList.value = Results.Failure(results.throwable)
        }
    }
}
