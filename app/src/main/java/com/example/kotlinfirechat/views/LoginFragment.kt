package com.example.kotlinfirechat.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinfirechat.R
import com.example.kotlinfirechat.data.FirebaseAuthState
import com.example.kotlinfirechat.databinding.FragmentLoginBinding
import com.example.kotlinfirechat.viewmodels.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getSharedViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = getSharedViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleClicks()
    }

    private fun handleClicks() {
        binding.submit.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            loginViewModel.firebaseCreateAccount(email, password).observe(viewLifecycleOwner, Observer {
                when(it) {
                    is FirebaseAuthState.Error -> {
                        binding.spinKit.visibility = View.GONE
                        Toast.makeText(context, "${it.exception}", Toast.LENGTH_LONG).show()
                        Timber.e(it.exception)
                    }
                    is FirebaseAuthState.Loading -> {
                        binding.spinKit.visibility = View.VISIBLE
                    }
                    is FirebaseAuthState.Success -> {
                        binding.spinKit.visibility = View.GONE
                        Timber.d("User  ${it.user}")
                    }
                }
            })
        }
    }
}
