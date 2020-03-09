package com.techcafe.todone.profile.edit

import androidx.lifecycle.ViewModel
import com.techcafe.todone.repository.TestRepository

// TODO: 消す
class ProfileEditorViewModel(
    private val repository: TestRepository
) : ViewModel() {
    val a = "test"

    init {
        repository.test()
    }
}