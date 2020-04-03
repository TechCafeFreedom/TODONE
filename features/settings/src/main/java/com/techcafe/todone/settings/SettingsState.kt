package com.techcafe.todone.settings

data class SettingsState(
    val isNightMode: Boolean
) {
    companion object {
        val INITIAL = SettingsState(
            isNightMode = false
        )
    }
}