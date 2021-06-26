package com.ishwar_arcore.explorebuddy.views.activities.signin

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.ishwar_arcore.explorebuddy.databinding.ActivitySignInBinding
import com.ishwar_arcore.explorebuddy.views.activities.home.HomeActivity
import com.ishwar_arcore.explorebuddy.views.activities.signup.SignUpActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mAuth = FirebaseAuth.getInstance()
        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnSignIn.setOnClickListener {
            logInUser()
        }

    }

   /** override fun onStart() {
        super.onStart()
        val user = mAuth.currentUser
        if (user != null) {
            redirect()
        }
    }

    private fun redirect() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }**/

    private fun logInUser() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etEmail.error = "Email is required"
            binding.etEmail.requestFocus()
            return
        }
        if (password.isEmpty()) {
            binding.etPassword.error = "Password is required"
            binding.etPassword.requestFocus()
            return
        }
        if (password.length < 6) {
            binding.etPassword.error = "Min password length should be 6 characters!"
            binding.etPassword.requestFocus()
            return
        }
        binding.progressBar.visibility = View.VISIBLE
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = FirebaseAuth.getInstance().currentUser
                if (user!!.isEmailVerified) {
                    binding.progressBar.visibility = View.GONE
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                } else {
                    user!!.sendEmailVerification()
                    binding.progressBar.visibility = View.GONE
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                    Toast.makeText(
                        this,
                        "Check your email to verify your account",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                Toast.makeText(
                    this,
                    "Failed to login please check your credentials",
                    Toast.LENGTH_LONG
                ).show()
            }
        }


    }
}