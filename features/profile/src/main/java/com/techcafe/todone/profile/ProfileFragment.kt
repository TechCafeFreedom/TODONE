package com.techcafe.todone.profile

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.techcafe.todone.profile.databinding.FragmentProfileBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProfileBinding.bind(view)

        val sharedPref = activity?.getSharedPreferences("USER", Context.MODE_PRIVATE)
        binding.userNameText.text = sharedPref?.getString("NAME", "")
        val thumbnail = sharedPref?.getString("THUMBNAIL", "")
        val thumbnailBitmap = BitmapFactory.decodeFile(thumbnail)
        binding.iconImageView.setImageBitmap(thumbnailBitmap) // ここもこれでいいのか謎

        binding.editButton.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_edit_profile)
        }

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_profile_to_board)
        }

        viewModel.getUserData()

        viewModel.userName.observe(viewLifecycleOwner) {
            binding.userNameText.text = it
        }
        viewModel.thumbnail.observe(viewLifecycleOwner) {
            binding.iconImageView.setImageBitmap(BitmapFactory.decodeFile(it))
        }
    }
}
