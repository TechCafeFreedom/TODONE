package com.techcafe.todone.board.ui.label_test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.usecase.GetLabelsUseCase
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.launch
import techcafe.todone.Results

// TODO: あとで消す
class LabelTestViewModel(
    private val getUseCase: GetLabelsUseCase
) : ViewModel() {
    private val results = getUseCase.labelList

    val labelList = results.map { it as? Results.Success }.map { it?.data?.get(0) }

    val isLoading = results.map { it is Results.Loading }

    val error = LiveEvent<Throwable>().apply {
        addSource(results) { if (it is Results.Failure) value = it.throwable }
    }

    fun getLabelList() {
        viewModelScope.launch {
            getUseCase.getBoardLabels(1)
        }
    }
}