package com.techcafe.todone.profile.edit

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.techcafe.todone.profile.R
import com.techcafe.todone.profile.databinding.FragmentEditProfileBinding
import org.koin.android.viewmodel.ext.android.viewModel

class EditProfileFragment : Fragment() {

    private lateinit var binding: FragmentEditProfileBinding
    private val viewModel: EditProfileViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentEditProfileBinding.bind(view)

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_edit_profile_to_profile)
        }

        binding.iconImage.setOnClickListener {
            // TODO: ローカルのファイルストレージ見に行って画像設定できるようにする
        }

        binding.saveButton.setOnClickListener {
            val name = binding.userNameEditText.text.toString()
            val sharedPref = activity?.getSharedPreferences("USER", Context.MODE_PRIVATE)
            viewModel.updateUser()
            sharedPref?.edit {
                putString("NAME", name)
                putString("THUMBNAIL", "")
            }
        }
    }
}
