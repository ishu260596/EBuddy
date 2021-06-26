package com.ishwar_arcore.explorebuddy.views.activities.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.ishwar_arcore.explorebuddy.R
import com.ishwar_arcore.explorebuddy.views.activities.home.HomeActivity
import com.ishwar_arcore.explorebuddy.views.activities.signin.SignInActivity

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DISPLAY_LENGTH = 2000
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mAuth = FirebaseAuth.getInstance()
        Handler().postDelayed({
            val mainIntent = Intent(this, SignInActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}