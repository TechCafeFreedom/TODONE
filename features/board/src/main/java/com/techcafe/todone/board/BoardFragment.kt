package com.techcafe.todone.board

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.techcafe.todone.board.databinding.FragmentBoardBinding

class BoardFragment : Fragment(R.layout.fragment_board) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        val binding = FragmentBoardBinding.bind(view)

        val adapter = BoardAdapter()

        binding.apply {
            binding.viewpager.adapter = adapter
            adapter.setItem(sampleItem)
        }
    }
}
