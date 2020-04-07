package com.techcafe.todone.settings

data class SettingsState(
    val nightMode: NightMode
) {
    companion object {
        val INITIAL = SettingsState(nightMode = NightMode.SYSTEM)
    }
}
