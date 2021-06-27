package com.ishwar_arcore.explorebuddy.views.activities.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ishwar_arcore.explorebuddy.R
import com.ishwar_arcore.explorebuddy.databinding.ActivityHomeBinding
import com.ishwar_arcore.explorebuddy.databinding.ActivitySignUpBinding
import com.ishwar_arcore.explorebuddy.views.activities.groupview.ViewGroupActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.tvJoinGroup.setOnClickListener {
            val intent = Intent(this,ViewGroupActivity::class.java)
            startActivity(intent)
        }

    }
}