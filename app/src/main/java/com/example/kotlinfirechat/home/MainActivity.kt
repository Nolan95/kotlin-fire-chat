package com.example.kotlinfirechat.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.kotlinfirechat.R
import com.example.kotlinfirechat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_fragment).navigateUp()

    override fun onBackPressed() {
        when (supportFragmentManager.primaryNavigationFragment?.childFragmentManager?.fragments?.first()) {
            is MessageFragment -> finish()
            else -> super.onBackPressed()
        }
    }
}
