package com.techcafe.todone.board.viewModel

import androidx.lifecycle.ViewModel
import com.techcafe.todone.repository.TestRepository

class BoardCreateViewModel(
//    private val repository: TestRepository
) : ViewModel() {
    var boardText:String = ""
    var boardDesc:String = ""
    //TODO ココをRepository実装後処理差し替える repository.createBoard
    fun createBoard() {
    }
}
