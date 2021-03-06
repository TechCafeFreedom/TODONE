package com.techcafe.todone.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.techcafe.todone.home.animation.ZoomOutPageTransformer
import com.techcafe.todone.home.databinding.FragmentBoardBinding
import com.techcafe.todone.home.model.SampleModel
import com.techcafe.todone.home.ui.BoardAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoardFragment : Fragment(R.layout.fragment_board) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentBoardBinding.bind(view)

        val adapter = BoardAdapter()

        val sampleItem = listOf(
            SampleModel(
                title = "Hogeeeee",
                description = "最初のBoardだよ"
            ),
            SampleModel(
                title = "Fugaaaaa",
                description = "2つ目のBoardだよ"
            ),
            SampleModel(
                title = "Piyooooo",
                description = "3つ目のBoardだよ"
            ),
            SampleModel(
                title = "Hogeraaaaa",
                description = "最後ののBoardだよ"
            )
        )

        binding.viewpager.offscreenPageLimit = 2
        binding.viewpager.setPageTransformer(ZoomOutPageTransformer())

        binding.viewpager.apply {
            this.adapter = adapter
            adapter.setItem(sampleItem)
        }

        binding.fab.setOnClickListener {
            val dialog = CreateBoardFragment(this)
            dialog.show(childFragmentManager, "CreateBoardFragment")
        }
    }
}
