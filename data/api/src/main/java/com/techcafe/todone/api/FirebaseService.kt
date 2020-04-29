package com.techcafe.todone.api

import com.techcafe.todone.api.model.UserResponse
import kotlinx.coroutines.flow.Flow

interface FirebaseService {
    val isLogin: Flow<Boolean>
    suspend fun signUpWithMail(email: String, pass: String): UserResponse
    suspend fun signInWithEmail(email: String, pass: String): UserResponse
    suspend fun getToken(): String?
}
