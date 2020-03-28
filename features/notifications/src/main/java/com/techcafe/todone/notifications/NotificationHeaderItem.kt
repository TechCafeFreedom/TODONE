package com.techcafe.todone.notifications

import com.techcafe.todone.notifications.databinding.NotificationHeaderItemBinding
import com.xwray.groupie.databinding.BindableItem

class NotificationHeaderItem(private val headerDateText: String) : BindableItem<NotificationHeaderItemBinding>() {
    override fun getLayout(): Int = R.layout.notification_header_item

    override fun bind(viewBinding: NotificationHeaderItemBinding, position: Int) {
        viewBinding.headerDateText = headerDateText
    }
}