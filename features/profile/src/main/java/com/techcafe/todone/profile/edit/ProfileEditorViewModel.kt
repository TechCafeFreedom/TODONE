package com.techcafe.todone.profile.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techcafe.todone.repository.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// TODO: 消す
@HiltViewModel
class ProfileEditorViewModel @Inject constructor(
    private val repository: TestRepository
) : ViewModel() {
    fun testMessage() {
        viewModelScope.launch(Dispatchers.IO) {
        }
    }
}
