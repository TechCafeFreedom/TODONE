package com.techcafe.todone.board.viewModel

import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import com.jraska.livedata.TestLifecycle
import com.jraska.livedata.TestObserver
import com.jraska.livedata.test

@RunWith(MockitoJUnitRunner::class)
class BoardCreateViewModelTest {

    @Mock
    lateinit var viewModel: BoardCreateViewModel

    @Before
    fun setup(){
    }

    @Test
    fun `CreateBoard-エラー表示-Title`() {
        viewModel.errorTitle
            .test()
            .assertHasValue()
        viewModel.createBoard()
//        assertThat(viewModel.errorTitle.value)
//            .isNotNull()
    }

//    @Test
//    fun `CreateBoard-エラー表示-Desc`() {
//        assertThat(viewModel.errorDesc.value)
//            .isNull()
//        viewModel.createBoard()
//        assertThat(viewModel.errorDesc.value)
//            .isNotNull()
//    }
//
//    @Test
//    fun `CreateBoard-エラー非表示-Title`() {
//        assertThat(viewModel.errorTitle.value)
//            .isNull()
//        viewModel.boardTitle = "hoge"
//        viewModel.createBoard()
//        assertThat(viewModel.errorTitle.value)
//            .isNull()
//    }
//
//    @Test
//    fun `CreateBoard-エラー非表示-Desc`() {
//        assertThat(viewModel.errorDesc.value)
//            .isNull()
//        viewModel.boardDesc = "hoge"
//        viewModel.createBoard()
//        assertThat(viewModel.errorTitle.value)
//            .isNull()
//    }
}