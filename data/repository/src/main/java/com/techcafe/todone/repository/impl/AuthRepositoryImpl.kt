package com.techcafe.todone.repository.impl

import androidx.lifecycle.asLiveData
import com.techcafe.todone.api.FirebaseService
import com.techcafe.todone.repository.AuthRepository
import com.techcafe.todone.repository.mapper.toModel
import techcafe.todone.Results
import techcafe.todone.User
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val service: FirebaseService
) : AuthRepository {

    override val isLogin = service.isLogin.asLiveData()

    override suspend fun signUpWithMail(email: String, pass: String): Results<User> = Results {
        service.signUpWithMail(email, pass).toModel()
    }

    override suspend fun signInWithEmail(email: String, pass: String): Results<User> {
        return try {
            val user = service.signUpWithMail(email, pass).toModel()
            Results.Success(user)
        } catch (e: Throwable) {
            Results.Failure(e)
        }
    }
}
