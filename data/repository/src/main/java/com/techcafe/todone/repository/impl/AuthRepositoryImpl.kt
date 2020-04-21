package com.techcafe.todone.repository.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.techcafe.todone.repository.AuthRepository
import kotlinx.coroutines.tasks.await
import techcafe.todone.Results
import techcafe.todone.User
import java.util.*

class AuthRepositoryImpl : AuthRepository {
    private val auth = FirebaseAuth.getInstance()

    private val _isLogin = MutableLiveData(auth.currentUser != null)
    override val isLogin: LiveData<Boolean> get() = _isLogin

    override suspend fun signUpWithMail(email: String, pass: String): Results<User> {
        return try {
            val authResult = auth.createUserWithEmailAndPassword(email, pass)
                .await()
            val authUser = authResult.user
            val info = authResult.additionalUserInfo
            val user = User(
                id = UUID.randomUUID().toString(),
                name = info.username ?: "",
                thumbnail = authUser.photoUrl?.toString() ?: ""
            )
            _isLogin.value = true
            Results.Success(user)
        } catch (e: Throwable) {
            Results.Failure(e)
        }
    }

    override suspend fun signInWithEmail(email: String, pass: String): Results<User> {
        return try {
            val authResult = auth.signInWithEmailAndPassword(email, pass)
                .await()
            val authUser = authResult.user
            val info = authResult.additionalUserInfo
            val user = User(
                id = UUID.randomUUID().toString(),
                name = info.username,
                thumbnail = authUser.photoUrl.toString()
            )
            _isLogin.value = true
            Results.Success(user)
        } catch (e: Throwable) {
            Results.Failure(e)
        }
    }
}