package com.example.kotlinfirechat.signin


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.kotlinfirechat.R
import com.example.kotlinfirechat.databinding.FragmentSigninBinding
import com.example.presentation.base.BaseView
import com.example.presentation.signin.SignInIntent
import com.example.presentation.signin.SignInState
import com.example.presentation.signin.SignInViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.getSharedViewModel

/**
 * A simple [Fragment] subclass.
 */
@ExperimentalCoroutinesApi
@FlowPreview
class SignInFragment : Fragment(), BaseView<SignInState, SignInIntent> {

    private lateinit var binding: FragmentSigninBinding

    private lateinit var signInViewModel: SignInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signInViewModel = getSharedViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signin, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)
        bindViewModel()
    }


    override fun render(state: SignInState) {
        when (state) {
            is SignInState.SignInProgressState -> binding.spinKit.visibility = View.VISIBLE
            is SignInState.SignInSuccess -> {
                binding.spinKit.visibility = View.GONE
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
            is SignInState.SignInError -> {
                binding.spinKit.visibility = View.GONE
                Toast.makeText(context, "${state.exception.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun intents(): Flow<SignInIntent> {
        return callbackFlow {
            binding.submit.setOnClickListener {
                offer(
                    SignInIntent.SubmitSignInForm(
                        email = binding.email.text.toString(),
                        password = binding.password.text.toString()
                    )
                )
            }
            awaitClose { binding.submit.setOnClickListener(null) }
        }
    }

    private fun bindViewModel() {
        signInViewModel = getSharedViewModel()
        signInViewModel.states().observe(viewLifecycleOwner, ::render)
        intents().onEach(signInViewModel::processIntents).launchIn(lifecycleScope)
    }
}
