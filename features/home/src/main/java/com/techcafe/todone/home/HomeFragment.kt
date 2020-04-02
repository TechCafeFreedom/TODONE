package com.techcafe.todone.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.techcafe.todone.home.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding
    lateinit var controller: HomeController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner

        controller = HomeController()

        binding.recyclerView.also {
            it.setController(controller)
        }

        val sampleData: List<Pair<String, String>> = emptyList() //listOf(
//            "ProjectName" to "ProjectName",
//            "toを初めて知った" to "toを初めて知った",
//            "データ持ってくる" to "どこからとりあえず取ろう"
//        )

        controller.setData(sampleData)
    }
}
