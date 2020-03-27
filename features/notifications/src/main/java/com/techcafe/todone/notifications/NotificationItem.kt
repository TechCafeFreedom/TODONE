package com.techcafe.todone.notifications

import com.techcafe.todone.notifications.databinding.NotificationItemBinding
import com.xwray.groupie.databinding.BindableItem

class NotificationItem(private val notification: Notification) :
    BindableItem<NotificationItemBinding>() {
    override fun getLayout(): Int = R.layout.notification_item

    override fun bind(viewBinding: NotificationItemBinding, position: Int) {
        viewBinding.notification = notification
    }
}