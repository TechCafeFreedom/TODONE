package com.techcafe.todone.profile.edit

import android.content.Context
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import com.techcafe.todone.repository.TestRepository

class EditProfileViewModel(
    private val context: Context,
    private val repository: TestRepository
) : ViewModel() {
    fun updateUser(name: String, thumbnail: String) {
        // TODO: JWTのTokenをヘッダーに混ぜてサーバにPOST
        val sharedPref = context.getSharedPreferences("USER", Context.MODE_PRIVATE)
        sharedPref.edit {
            putString("NAME", name)
            putString("THUMBNAIL", thumbnail)
        }
    }
}
