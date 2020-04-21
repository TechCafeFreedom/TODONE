package com.techcafe.todone.board

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.techcafe.todone.board.databinding.FragmentCreateBinding
import com.techcafe.todone.board.viewModel.BoardCreateViewModel

class CreateBoardFragment : DialogFragment() {
    private lateinit var dialog: AlertDialog
    private lateinit var binding: FragmentCreateBinding
    private val viewmodel: BoardCreateViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        binding = FragmentCreateBinding.inflate(inflater)
        binding.viewModel = viewmodel
        binding.lifecycleOwner = this

        dialog = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setView(binding.root)
                .setPositiveButton("作成", null)
                .setNegativeButton("キャンセル",
                    DialogInterface.OnClickListener { dialog, _ ->
                        dialog.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity must not be null")

        dialog.show()

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            viewmodel.createBoard()
        }

        viewmodel.errorTitle.observe(this) {}
        viewmodel.errorDesc.observe(this) {}

        return dialog
    }
}