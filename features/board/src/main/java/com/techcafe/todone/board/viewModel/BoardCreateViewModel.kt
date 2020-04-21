package com.techcafe.todone.board.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class BoardCreateViewModel(
//    private val repository: TestRepository
) : ViewModel() {
    var boardTitle = MutableLiveData<String>()
    var boardDesc = MutableLiveData<String>()
    val errorTitle = MutableLiveData<String?>()
    val errorDesc = MutableLiveData<String?>()

    init {
        boardTitle.value = ""
        boardDesc.value = ""
        errorTitle.value = null
        errorDesc.value = null
    }

    //TODO ココをRepository実装後処理差し替える repository.createBoard
    fun createBoard() {
        errorTitle.value = null
        errorDesc.value = null
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
            errorTitle.value = "タイトルを入力してください。"
            flag = false
        }
        if(boardDesc.value.isNullOrEmpty()){
            errorDesc.value = "説明を入力してください。"
            flag = false
        }

        return flag
    }
}
