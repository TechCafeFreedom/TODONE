package com.techcafe.todone.board.ui.label_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.techcafe.todone.board.databinding.FragmentLabelTestBinding
import org.koin.android.viewmodel.ext.android.viewModel

class LabelTestFragment : Fragment() {

    private lateinit var binding: FragmentLabelTestBinding
    private val viewModel: LabelTestViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLabelTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.labelList.observe(viewLifecycleOwner){

        }
    }
}
