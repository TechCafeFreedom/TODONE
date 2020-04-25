package com.techcafe.todone.api

import com.google.firebase.auth.FirebaseAuth
import com.techcafe.todone.api.model.UserResponse
import java.util.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

@ExperimentalCoroutinesApi
class FirebaseServiceImpl(
    private val auth: FirebaseAuth
) : FirebaseService {

    override val isLogin
        get() = callbackFlow {
            val listener = FirebaseAuth.AuthStateListener { auth ->
                offer(auth.currentUser != null)
            }
            auth.addAuthStateListener(listener)
            awaitClose { auth.removeAuthStateListener(listener) }
        }

    override suspend fun signUpWithMail(email: String, pass: String): UserResponse {
        val authResult = auth.createUserWithEmailAndPassword(email, pass).await()
        val authUser = authResult.user
        return UserResponse(
            id = UUID.randomUUID().toString(),
            name = authUser.displayName ?: "",
            thumbnail = authUser.photoUrl?.toString() ?: ""
        )
    }

    override suspend fun signInWithEmail(email: String, pass: String): UserResponse {
        val authResult = auth.signInWithEmailAndPassword(email, pass).await()
        val authUser = authResult.user
        return UserResponse(
            id = UUID.randomUUID().toString(),
            name = authUser.displayName ?: "",
            thumbnail = authUser.photoUrl?.toString() ?: ""
        )
    }

    override suspend fun getToken(): String? =
        auth.currentUser?.getIdToken(true)?.await()?.token
}
