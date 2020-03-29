package com.techcafe.todone.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.techcafe.todone.profile.edit.EditProfileActivity
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.back_button

class ProfileActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent =
            Intent(context, ProfileActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        back_button.setOnClickListener { finish() }

        edit_button.setOnClickListener {
            val intent = EditProfileActivity.createIntent(this)
            startActivity(intent)
        }
    }
}
