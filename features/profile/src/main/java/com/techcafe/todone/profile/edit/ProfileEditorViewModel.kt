package com.techcafe.todone.profile.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techcafe.todone.repository.TestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// TODO: 消す
class ProfileEditorViewModel(
    private val repository: TestRepository
) : ViewModel() {
    fun testMessage() {
        viewModelScope.launch(Dispatchers.IO) {
        }
    }
}
