package com.example.kotlinfirechat.views


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.kotlinfirechat.R
import com.example.kotlinfirechat.databinding.FragmentSplashScreenBinding

/**
 * A simple [Fragment] subclass.
 */
class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_splash_screen, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let { (activity as MainActivity).actionBar?.hide() }
        Handler().postDelayed({
            context?.let {
                findNavController().navigate(
                    R.id.action_splashScreenFragment2_to_loginFragment,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(
                            R.id.splashScreenFragment2,
                            true).build())
            }
        }, 2500)
    }


}
