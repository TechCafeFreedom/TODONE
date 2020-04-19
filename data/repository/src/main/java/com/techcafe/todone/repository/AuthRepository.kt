package com.techcafe.todone.repository

import androidx.lifecycle.LiveData
import techcafe.todone.Results
import techcafe.todone.User

interface AuthRepository {
    val isLogin: LiveData<Boolean>
    suspend fun signUpWithMail(email: String, pass: String): Results<User>
    suspend fun signInWithEmail(email: String, pass: String): Results<User>
}