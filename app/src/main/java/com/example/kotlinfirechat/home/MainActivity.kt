package com.example.kotlinfirechat.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.kotlinfirechat.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_fragment).navigateUp()

    override fun onBackPressed() {
        super.onBackPressed()
        when (supportFragmentManager.primaryNavigationFragment?.childFragmentManager?.fragments?.first()) {
            is HomeFragment -> finish()
            else -> super.onBackPressed()
        }
    }
}
