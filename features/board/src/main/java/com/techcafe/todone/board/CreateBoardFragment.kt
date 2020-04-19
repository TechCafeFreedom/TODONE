package com.techcafe.todone.board

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.techcafe.todone.board.viewModel.BoardCreateViewModel
import com.techcafe.todone.board.databinding.FragmentCreateBinding

class CreateBoardFragment : DialogFragment() {
    private lateinit var dialog: AlertDialog
    private lateinit var binding: FragmentCreateBinding
    private val viewmodel: BoardCreateViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialog = activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            binding = FragmentCreateBinding.bind(inflater.inflate(R.layout.fragment_create, null))
            builder.setView(binding.root)
                .setPositiveButton("作成", null)
                .setNegativeButton("キャンセル",
                    DialogInterface.OnClickListener { dialog, _ ->
                        dialog.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity must not be null")

        dialog.show()
        binding.viewModel = viewmodel
//        binding.lifecycleOwner = this

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            viewmodel.createBoard()
        }
        return dialog
    }
}