package com.techcafe.todone.profile

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel(
    private val context: Context
) : ViewModel() {

    private val _userName: MutableLiveData<String> = MutableLiveData()
    private val _thumbnail: MutableLiveData<String> = MutableLiveData()
    val userName: LiveData<String> = _userName
    val thumbnail: LiveData<String> = _thumbnail

    fun getUserData() {
        val sharedPref = context.getSharedPreferences("USER", Context.MODE_PRIVATE)
        val userName = sharedPref.getString("NAME", "")
        val thumbnail = sharedPref.getString("THUMBNAIL", "")
        _userName.value = userName
        _thumbnail.value = thumbnail
    }
}
