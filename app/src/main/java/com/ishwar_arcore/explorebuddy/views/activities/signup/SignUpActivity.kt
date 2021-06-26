package com.ishwar_arcore.explorebuddy.views.activities.signup

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.ishwar_arcore.explorebuddy.databinding.ActivitySignUpBinding
import com.ishwar_arcore.explorebuddy.views.activities.details.DetailActivity
import com.ishwar_arcore.explorebuddy.views.activities.home.HomeActivity
import com.ishwar_arcore.explorebuddy.views.activities.signin.SignInActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mAuth = FirebaseAuth.getInstance()
        binding.tvSignIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnSignUp.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
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
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Register successfully", Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.GONE
                    val intent = Intent(this, DetailActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        this,
                        "Register unsuccessfully please try Again!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

    }
}