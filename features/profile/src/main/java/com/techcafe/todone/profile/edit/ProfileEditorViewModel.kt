package com.techcafe.todone.profile.edit

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techcafe.todone.repository.TestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// TODO: 消す
class ProfileEditorViewModel(
    private val repository: TestRepository
) : ViewModel() {
    fun testMessage() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTestUserData()
        }
    }
}
