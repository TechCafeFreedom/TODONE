package com.techcafe.todone.home

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import com.techcafe.todone.home.databinding.FragmentCreateBinding
import com.techcafe.todone.home.viewModel.BoardCreateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateBoardFragment(private val lifecycleOwner: LifecycleOwner) : DialogFragment() {
    private lateinit var dialog: AlertDialog
    private lateinit var binding: FragmentCreateBinding
    private val viewModel: BoardCreateViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        binding = FragmentCreateBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = lifecycleOwner

        dialog = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setView(binding.root)
                .setPositiveButton("作成", null)
                .setNegativeButton("キャンセル") { dialog, _ ->
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity must not be null")

        dialog.show()

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            viewModel.createBoard()
        }

        viewModel.errorTitleFlag.observe(lifecycleOwner) {}
        viewModel.errorDescFlag.observe(lifecycleOwner) {}

        return dialog
    }
}
