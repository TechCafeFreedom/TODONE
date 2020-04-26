package com.techcafe.todone.board.viewModel

import org.assertj.core.api.Assertions.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith()
class BoardCreateViewModelTest {
    lateinit var viewModel:BoardCreateViewModel
    @Before
    fun setUp() {
        viewModel = BoardCreateViewModel()
    }

    @Test
    fun `CreateBoard-エラー表示の正当性-Title`() {
        assertThat(viewModel.errorTitle)
            .isNull()
        viewModel.createBoard()
        assertThat(viewModel.errorTitle)
            .isNotNull
    }
    @Test
    fun `CreateBoard-エラー表示の正当性-Desc`() {
        assertThat(viewModel.errorDesc)
            .isNull()
        viewModel.createBoard()
        assertThat(viewModel.errorDesc)
            .isNotNull
    }
}