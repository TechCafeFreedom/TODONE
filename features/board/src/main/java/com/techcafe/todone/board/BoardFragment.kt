package com.techcafe.todone.board

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.techcafe.todone.board.animation.ZoomOutPageTransformer
import com.techcafe.todone.board.databinding.FragmentBoardBinding
import com.techcafe.todone.board.model.SampleModel
import com.techcafe.todone.board.ui.BoardAdapter

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

        binding.viewpager.setPageTransformer(ZoomOutPageTransformer())

        binding.viewpager.apply {
            binding.viewpager.adapter = adapter
            adapter.setItem(sampleItem)
        }
    }
}