package com.techcafe.todone.profile.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.techcafe.todone.profile.R
import com.techcafe.todone.profile.databinding.FragmentEditProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.android.ext.android.bind

class EditProfileFragment : Fragment() {

    private lateinit var binding: FragmentEditProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
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
    }

}
