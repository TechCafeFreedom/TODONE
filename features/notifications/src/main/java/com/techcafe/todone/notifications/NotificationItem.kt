package com.techcafe.todone.notifications

import com.techcafe.todone.notifications.databinding.NotificationItemBinding
import com.xwray.groupie.databinding.BindableItem

class NotificationItem(private val notification: Notification) :
    BindableItem<NotificationItemBinding>(ID.hashCode().toLong()) {

    companion object{
        private const val ID = "notificationItem"
    }

    override fun getLayout(): Int = R.layout.notification_item

    override fun bind(viewBinding: NotificationItemBinding, position: Int) {
        viewBinding.notification = notification
    }
}