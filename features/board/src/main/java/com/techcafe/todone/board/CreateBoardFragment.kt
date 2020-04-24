package com.techcafe.todone.board

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import com.techcafe.todone.board.databinding.FragmentCreateBinding
import com.techcafe.todone.board.viewModel.BoardCreateViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class CreateBoardFragment(private val lifecycleOwner: LifecycleOwner) : DialogFragment() {
    private lateinit var dialog: AlertDialog
    private lateinit var binding: FragmentCreateBinding
    private val viewModel: BoardCreateViewModel by viewModel()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        binding = FragmentCreateBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

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

        viewModel.errorTitle.observe(lifecycleOwner) {}
        viewModel.errorDesc.observe(lifecycleOwner) {}

        return dialog
    }
}
