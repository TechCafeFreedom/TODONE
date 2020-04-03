package com.techcafe.todone.settings

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    private val state = MutableLiveData<SettingsState>(SettingsState.INITIAL)


    fun setNightMode(newValue: Boolean) {
        state.value?.copy(isNightMode = newValue)
    }
}