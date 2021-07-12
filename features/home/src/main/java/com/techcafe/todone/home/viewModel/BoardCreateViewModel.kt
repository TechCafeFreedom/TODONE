package com.techcafe.todone.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BoardCreateViewModel @Inject constructor(
//    private val repository: TestRepository
) : ViewModel() {
    val boardTitle = MutableLiveData("")
    val boardDesc = MutableLiveData("")
    private val _errorTitleFlag = MutableLiveData(false)
    private val _errorDescFlag = MutableLiveData(false)

    val errorTitleFlag: LiveData<Boolean?>
        get() = _errorTitleFlag
    val errorDescFlag: LiveData<Boolean?>
        get() = _errorDescFlag

    // TODO ココをRepository実装後処理差し替える repository.createBoard
    fun createBoard() {
        _errorTitleFlag.value = false
        _errorDescFlag.value = false

        // Repositoryの関数呼び出し
        if (validateInput()) {
            Timber.d("SUCCESS")
        } else {
            Timber.d("FAILURE")
        }
    }

    private fun validateInput(): Boolean {
        var flag = true
        val title = boardTitle.value ?: return false
        val desc = boardDesc.value ?: return false

        if (title.isEmpty()) {
            _errorTitleFlag.value = true
            flag = false
        }
        if (desc.isEmpty()) {
            _errorDescFlag.value = true
            flag = false
        }

        return flag
    }
}
