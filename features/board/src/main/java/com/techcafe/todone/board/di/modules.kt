package com.techcafe.todone.board.di

import com.techcafe.todone.board.ui.board.BoardCreateViewModel
import com.techcafe.todone.board.ui.label_test.LabelTestViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val boardModule = module {
    viewModel { BoardCreateViewModel() }
    viewModel { LabelTestViewModel(get()) }
}
