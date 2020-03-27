package com.techcafe.todone.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.techcafe.todone.notifications.databinding.FragmentNotificationsBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder


class NotificationsFragment : Fragment() {

    private val viewModel: NotificationsViewModel by lazy {
        ViewModelProvider(this).get(NotificationsViewModel::class.java)
    }
    private val notificationsAdapter = GroupAdapter<GroupieViewHolder>()
    private lateinit var binding: FragmentNotificationsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)
        binding = FragmentNotificationsBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notificationsAdapter.apply {
            addAll(viewModel.notificationsList)
        }
        binding.notificationsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = notificationsAdapter
        }
    }
}
