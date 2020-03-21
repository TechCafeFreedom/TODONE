package com.techcafe.todone.auth.signin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.techcafe.todone.auth.R
import com.techcafe.todone.auth.databinding.FragmentSignInBinding

/**
 * A simple [Fragment] subclass.
 */
class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    companion object {
        private const val RC_SIGN_IN = 0
    }

    private lateinit var binding: FragmentSignInBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSignInBinding.bind(view)

        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            // TODO MainActivityへ遷移
            binding.textView.text = user.displayName
        } else {
            val configs = arrayListOf(
                AuthUI.IdpConfig.EmailBuilder().build()
            )
            val authIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(configs)
                .build()
            startActivityForResult(authIntent, RC_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode != RC_SIGN_IN) return
        val response = IdpResponse.fromResultIntent(data)
        if (resultCode == Activity.RESULT_OK) {
            // TODO MainActivityへ遷移
            Toast.makeText(requireContext(), "Signed in!", Toast.LENGTH_LONG).show()
            binding.textView.text = "Signed in with " + response?.email
        } else {
            val errorMessage = when {
                response == null -> R.string.sign_in_cancelled
                response.error?.errorCode == ErrorCodes.NO_NETWORK -> R.string.network_error
                else -> R.string.unknown_error
            }
            Toast.makeText(requireContext(), getString(errorMessage), Toast.LENGTH_LONG).show()
        }
    }
}
