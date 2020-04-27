package com.techcafe.todone.profile

import androidx.lifecycle.*
import com.techcafe.todone.repository.GetLabelsUseCase
import com.techcafe.todone.repository.di.repositoryModule
import kotlinx.coroutines.launch
import techcafe.todone.Label
import techcafe.todone.Results

class LabelViewModel(
    private val useCase: GetLabelsUseCase
) : ViewModel() {
    val labelList = useCase.labelList

    val isLoading = labelList.map {it is Results.Loading }

    val error = LiveEvent<Throwable>().apply {
        addSource(labelList) {
             if (it is Results.Failure) value = it.throwable
        }
    }

    fun getBoardLabel(id: Int) {
        viewModelScope.launch {
            useCase.getBoardLabels(id)
        }
    }
}
