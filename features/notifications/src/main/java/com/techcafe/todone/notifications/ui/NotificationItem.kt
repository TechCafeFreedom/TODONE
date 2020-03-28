package com.techcafe.todone.notifications.ui

import com.techcafe.todone.notifications.R
import com.techcafe.todone.notifications.databinding.NotificationItemBinding
import com.techcafe.todone.notifications.model.Notification
import com.xwray.groupie.databinding.BindableItem

class NotificationItem(private val notification: Notification) :
    BindableItem<NotificationItemBinding>(ID.hashCode().toLong()) {

    companion object{
        private const val ID = "notificationItem"
    }

    override fun getLayout(): Int =
        R.layout.notification_item

    override fun bind(viewBinding: NotificationItemBinding, position: Int) {
        viewBinding.notification = notification
    }
}