package com.techcafe.todone.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.techcafe.todone.auth.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity(R.layout.activity_sign_in) {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
    }
}
