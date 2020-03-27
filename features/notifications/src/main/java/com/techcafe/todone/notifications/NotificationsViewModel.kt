package com.techcafe.todone.notifications

import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {
    val notificationsList = arrayListOf(
        NotificationItem(
            Notification(
                taskName = "お買い物行く",
                description = "晩ごはんのおかずとお菓子とか",
                createdDate = "2020/03/22"
            )
        ),
        NotificationItem(
            Notification(
                taskName = "大学の課題やる",
                description = "数学のやつ",
                createdDate = "2020/03/1"
            )
        ),
        NotificationItem(
            Notification(
                taskName = "TODONE開発する",
                description = "Home画面つくってPR出す",
                createdDate = "2020/03/11"
            )
        )
    )
}