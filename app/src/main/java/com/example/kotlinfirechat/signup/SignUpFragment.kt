package com.example.kotlinfirechat.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import com.example.kotlinfirechat.R
import com.example.kotlinfirechat.databinding.FragmentSignUpBinding
import com.example.presentation.base.BaseView
import com.example.presentation.signup.SignUpIntent
import com.example.presentation.signup.SignUpState
import com.example.presentation.signup.SignUpViewModel
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
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@ExperimentalCoroutinesApi
@FlowPreview
class SignUpFragment : Fragment(), BaseView<SignUpState, SignUpIntent> {

    private lateinit var mViewModel: SignUpViewModel
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = getSharedViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
    }

    private fun bindViewModel() {
        mViewModel = getSharedViewModel()
        mViewModel.states().observe(viewLifecycleOwner, ::render)
        intents().onEach(mViewModel::processIntents).launchIn(lifecycleScope)
    }

    override fun render(state: SignUpState) {
        when (state) {
            is SignUpState.SignUpProgressState -> binding.spinKit.visibility = View.VISIBLE
            is SignUpState.SignUpSuccess -> {
                binding.spinKit.visibility = View.GONE
                Toast.makeText(context, "Hello ${state.user.fullName}", Toast.LENGTH_LONG).show()
            }
            is SignUpState.SignUpError -> {
                binding.spinKit.visibility = View.GONE
                Toast.makeText(context, state.exception.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun intents(): Flow<SignUpIntent> {
        return callbackFlow {
            binding.submit.setOnClickListener {
                offer(
                    SignUpIntent.SubmitSignUpForm(
                        email = binding.email.text.toString(),
                        password = binding.password.text.toString()
                    )
                )
            }
            awaitClose { binding.submit.setOnClickListener(null) }
        }
    }
}