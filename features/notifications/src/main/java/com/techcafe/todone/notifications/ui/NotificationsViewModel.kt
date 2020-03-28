package com.techcafe.todone.notifications.ui

import androidx.lifecycle.ViewModel
import com.techcafe.todone.notifications.model.Notification

class NotificationsViewModel : ViewModel() {
    val notificationsList = arrayListOf(
        NotificationHeaderItem(
            headerDateText = "2020/03/21"
        ),
        NotificationItem(
            Notification(
                taskName = "お買い物行く",
                description = "晩ごはんのおかずとお菓子とか",
                createdDate = "2020/03/21"
            )
        ),
        NotificationItem(
            Notification(
                taskName = "大学の課題やる",
                description = "数学のやつ",
                createdDate = "2020/03/21"
            )
        ),
        NotificationItem(
            Notification(
                taskName = "TODONE開発する",
                description = "Home画面つくってPR出す",
                createdDate = "2020/03/21"
            )
        ),
        NotificationHeaderItem(
            headerDateText = "2020/03/11"
        ),
        NotificationItem(
            Notification(
                taskName = "お買い物行く",
                description = "晩ごはんのおかずとお菓子とか",
                createdDate = "2020/03/11"
            )
        ),
        NotificationItem(
            Notification(
                taskName = "大学の課題やる",
                description = "数学のやつ",
                createdDate = "2020/03/11"
            )
        ),
        NotificationItem(
            Notification(
                taskName = "TODONE開発する",
                description = "Home画面つくってPR出す",
                createdDate = "2020/03/11"
            )
        ),
        NotificationHeaderItem(
            headerDateText = "2020/03/09"
        ),
        NotificationItem(
            Notification(
                taskName = "お買い物行く",
                description = "晩ごはんのおかずとお菓子とか",
                createdDate = "2020/03/09"
            )
        ),
        NotificationItem(
            Notification(
                taskName = "大学の課題やる",
                description = "数学のやつ",
                createdDate = "2020/03/09"
            )
        ),
        NotificationItem(
            Notification(
                taskName = "TODONE開発する",
                description = "Home画面つくってPR出す",
                createdDate = "2020/03/09"
            )
        )
    )
    // 仮のJson作って色々やろうと思ったけど断念した
//    private val fakeJson = """
//        {
//            "success" : true,
//            "response" : {
//                "todoNotificatons" : [
//                    {
//                        "date" : "2020/03/11",
//                        "body" : [
//                            {
//                                "taskName" : "お買い物行く",
//                                "description" : "晩ごはんのおかずとお菓子とか",
//                                "createdDate" : "2020/03/11"
//                            },
//                            {
//                                "taskName" : "大学の課題やる",
//                                "description" : "数学のやつ",
//                                "createdDate" : "2020/03/11"
//                            },
//                            {
//                                "taskName" : "TODONE開発する",
//                                "description" : "Home画面つくってPR出",
//                                "createdDate" : "2020/03/11"
//                            },
//                        ]
//                    },
//                    {
//                        "date" : "2020/03/14",
//                         "body" : [
//                            {
//                                "taskName" : "お買い物行く",
//                                "description" : "晩ごはんのおかずとお菓子とか",
//                                "createdDate" : "2020/03/14"
//                            },
//                            {
//                                "taskName" : "大学の課題やる",
//                                "description" : "数学のやつ",
//                                "createdDate" : "2020/03/14"
//                            },
//                            {
//                                "taskName" : "TODONE開発する",
//                                "description" : "Home画面つくってPR出",
//                                "createdDate" : "2020/03/14"
//                            },
//                        ]
//                    }
//                ]
//            }
//        }
//    """.trimIndent()
//    private val moshi = Moshi.Builder().build()
//    private val adapter = moshi.adapter(Notification::class.java)
//    val notificationsList = arrayListOf(
//        adapter.fromJson(fakeJson)?.let {
//            NotificationItem(it)
//        }
//    )
}