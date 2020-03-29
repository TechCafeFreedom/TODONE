package com.techcafe.todone.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.techcafe.todone.settings.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    lateinit var binding: FragmentSettingsBinding
    lateinit var controller: SettingController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner

        controller = SettingController()

        binding.recyclerView.also {
            it.setController(controller)
        }
        val list = listOf(
            "title" to "message",
            "タイトル" to "メッセージ",
            "タイトルだよ" to "メッセージだよ",
            "あいうえお" to "かきくけこ"
        )
        controller.setData(list)
    }
}
