package com.techcafe.todone.board.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class BoardCreateViewModel(
//    private val repository: TestRepository
) : ViewModel() {
    var boardTitle = MutableLiveData<String>()
    var boardDesc = MutableLiveData<String>()
    private val _errorTitle = MutableLiveData<String?>()
    private val _errorDesc = MutableLiveData<String?>()

    val errorTitle: LiveData<String?>
        get() = _errorTitle
    val errorDesc: LiveData<String?>
        get() = _errorDesc

    init {
        boardTitle.value = ""
        boardDesc.value = ""
        _errorTitle.value = null
        _errorDesc.value = null
    }

    //TODO ココをRepository実装後処理差し替える repository.createBoard
    fun createBoard() {
        _errorTitle.value = null
        _errorDesc.value = null
        //Repositoryの関数呼び出し
        if (validateInput()) {
            Timber.d("SUCCESS")
        } else {
            Timber.d("FAILURE")
        }
    }

    private fun validateInput(): Boolean {
        var flag = true

        if (boardTitle.value.isNullOrEmpty()) {
            _errorTitle.value = "タイトルを入力してください。"
            flag = false
        }
        if (boardDesc.value.isNullOrEmpty()) {
            _errorDesc.value = "説明を入力してください。"
            flag = false
        }

        return flag
    }
}
