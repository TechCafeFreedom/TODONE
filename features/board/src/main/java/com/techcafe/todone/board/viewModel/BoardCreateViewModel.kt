package com.techcafe.todone.board.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class BoardCreateViewModel(
//    private val repository: TestRepository
) : ViewModel() {
    var boardTitle: String = ""
    var boardDesc: String = ""
    val errorTitle = MutableLiveData<String?>()
    val errorDesc = MutableLiveData<String?>()

    init {
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

        if (boardTitle.isEmpty()) {
            errorTitle.value = "タイトルを入力してください。"
            flag = false
        }
        if(boardDesc.isEmpty()){
            errorDesc.value = "説明を入力してください。"
            flag = false
        }

        return flag
    }
}
