package com.techcafe.todone.auth.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hadilq.liveevent.LiveEvent
import com.techcafe.todone.repository.AuthRepository
import kotlinx.coroutines.launch
import techcafe.todone.Results
import techcafe.todone.User

class SignUpViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
    val isLogin = authRepository.isLogin

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    val error = LiveEvent<Throwable>()

    fun signUpWithEmail(email: String, pass: String) {
        viewModelScope.launch {
            when (val result = authRepository.signUpWithMail(email, pass)) {
                is Results.Success -> _user.value = result.data
                is Results.Failure -> error.value = result.throwable
            }
        }
    }
}