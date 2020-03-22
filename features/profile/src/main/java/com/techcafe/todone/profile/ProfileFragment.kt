package com.techcafe.todone.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.techcafe.todone.profile.edit.ProfileEditorViewModel
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.getViewModel

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model: ProfileEditorViewModel = getViewModel()
        model.TestMessage()
    }
}
