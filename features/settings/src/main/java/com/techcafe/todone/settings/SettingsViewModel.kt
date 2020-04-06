package com.techcafe.todone.settings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    val state = MutableLiveData(SettingsState.INITIAL)
    val nightMode = MutableLiveData(NightMode.SYSTEM)

    fun setNightMode(newValue: Boolean) {
        if (newValue) {
//            state.value?.copy(nightMode = NightMode.YES) // なぜか値入れれない
            nightMode.value = NightMode.YES
        } else {
//            state.value?.copy(nightMode = NightMode.NO) // なぜか値入れれない
            nightMode.value = NightMode.NO
        }
    }
}