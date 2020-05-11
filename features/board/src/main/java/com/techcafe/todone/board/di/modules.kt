package com.techcafe.todone.board.di

import com.techcafe.todone.board.ui.board.BoardCreateViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val boardModule = module {
    viewModel { BoardCreateViewModel() }
}
