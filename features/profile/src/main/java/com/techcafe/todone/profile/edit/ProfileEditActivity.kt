package com.techcafe.todone.profile.edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.techcafe.todone.profile.R
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileEditActivity : AppCompatActivity() {

    private val viewModel: ProfileEditorViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_edit)

        Log.d("ProfileEditActivity", "success inject ${viewModel.a} !")
    }
}
