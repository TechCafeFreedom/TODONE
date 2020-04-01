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
        val sample = listOf(
            "ProjectName" to "Description",
            "toを初めて知った" to "わーい",
            "このサンプルをviewModelに持たせる" to "そのうち"
        )

        controller.setData(sample)
    }
}
