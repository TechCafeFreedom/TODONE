package com.techcafe.todone.auth.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.techcafe.todone.auth.R
import com.techcafe.todone.auth.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    companion object {
        private const val RC_SIGN_IN = 0
    }

    //    private val testService: TestService by inject()
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentSignUpBinding.inflate(inflater, container, false).root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSignUpBinding.bind(view)


//        val user = FirebaseAuth.getInstance().currentUser
//        if (user != null) {
//            // TODO MainActivityへ遷移
//            binding.textView.text = user.displayName
//            getAuthTest()
//        } else {
//            val configs = arrayListOf(
//                AuthUI.IdpConfig.EmailBuilder().build()
//            )
//            val authIntent = AuthUI.getInstance()
//                .createSignInIntentBuilder()
//                .setAvailableProviders(configs)
//                .build()
//            startActivityForResult(authIntent, RC_SIGN_IN)
//        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode != RC_SIGN_IN) return
//        val response = IdpResponse.fromResultIntent(data)
//        if (resultCode == Activity.RESULT_OK) {
//            // TODO MainActivityへ遷移
//            Toast.makeText(requireContext(), "Signed in!", Toast.LENGTH_LONG).show()
//            binding.textView.text = "Signed in with " + response?.email
//            getAuthTest()
//        } else {
//            val errorMessage = when {
//                response == null -> R.string.sign_in_cancelled
//                response.error?.errorCode == ErrorCodes.NO_NETWORK -> R.string.network_error
//                else -> R.string.unknown_error
//            }
//            Toast.makeText(requireContext(), getString(errorMessage), Toast.LENGTH_LONG).show()
//        }
//    }
//
//    private fun getAuthTest() {
//        lifecycleScope.launch {
//            val response = testService.getAuthTest()
//            if (response.isSuccessful && response.body() != null) {
//                val authHeader = response.body()?.auth_header
//                binding.textView.text = authHeader
//            } else {
//                binding.textView.text = "Nothing"
//            }
//        }
//    }
}
