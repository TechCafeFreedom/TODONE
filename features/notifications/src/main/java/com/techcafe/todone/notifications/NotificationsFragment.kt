package com.techcafe.todone.notifications

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.techcafe.todone.notifications.controller.NotificationController
import com.techcafe.todone.notifications.databinding.FragmentNotificationsBinding
import com.techcafe.todone.notifications.model.SampleModel

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {
    lateinit var binding: FragmentNotificationsBinding
    lateinit var controller: NotificationController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotificationsBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner

        controller = NotificationController()

        binding.recyclerView.also {
            it.setController(controller)
        }

        val sampleData = listOf<SampleModel>(
            SampleModel(
                title = "通知１",
                description = "通知１だよー"
            ),
            SampleModel(
                title = "通知2",
                description = "通知2だよー"
            )
        )

        controller.setData(sampleData)
    }
}
