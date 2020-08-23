package com.example.kotlinfirechat.home


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.preferences.SessionModelImpl
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
            Timber.e("Login status ${SessionModelImpl.loginStatus}")
            if (SessionModelImpl.loginStatus)
                startActivity(Intent(this, HomeActivity::class.java))
            else
                startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2500)
    }

}
