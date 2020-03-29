package com.techcafe.todone.profile.edit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.techcafe.todone.profile.R
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.back_button

class EditProfileActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context): Intent =
            Intent(context, EditProfileActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        back_button.setOnClickListener { finish() }

        save_button.setOnClickListener {
            Toast.makeText(this, "保存しました", Toast.LENGTH_SHORT).show()
            finish()
        }

        icon_edit_button.setOnClickListener {  }
    }
}
