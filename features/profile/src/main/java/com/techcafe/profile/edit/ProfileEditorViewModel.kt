package com.techcafe.profile.edit

import androidx.lifecycle.ViewModel
import com.techcafe.repository.TestRepository

// TODO: 消す
class ProfileEditorViewModel(
    private val repository: TestRepository
) : ViewModel() {
    val a = "test"

    init {
        repository.test()
    }
}