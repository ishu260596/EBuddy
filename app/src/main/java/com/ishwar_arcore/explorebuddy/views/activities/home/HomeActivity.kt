package com.ishwar_arcore.explorebuddy.views.activities.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ishwar_arcore.explorebuddy.R
import com.ishwar_arcore.explorebuddy.databinding.ActivityDetailBinding
import com.ishwar_arcore.explorebuddy.databinding.ActivityHomeBinding
import com.ishwar_arcore.explorebuddy.views.activities.makegroup.MakeGroupActivity
import com.ishwar_arcore.explorebuddy.views.activities.users.UsersActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.makeGroup.setOnClickListener {
            val intent = Intent(this, MakeGroupActivity::class.java)
            startActivity(intent)


            binding.tvSearch.setOnClickListener(View.OnClickListener {

                val intent = Intent(this, UsersActivity::class.java)
                startActivity(intent)

            })
        }
    }
}