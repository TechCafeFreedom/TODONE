package com.techcafe.todone.settings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    val state = MutableLiveData(SettingsState.INITIAL)

    fun setNightMode(newValue: NightMode) {
        state.value?.copy(nightMode = newValue)
    }
}