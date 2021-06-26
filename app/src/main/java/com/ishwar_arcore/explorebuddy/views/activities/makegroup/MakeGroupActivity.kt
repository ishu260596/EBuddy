package com.ishwar_arcore.explorebuddy.views.activities.makegroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.ishwar_arcore.explorebuddy.R
import com.ishwar_arcore.explorebuddy.databinding.ActivityMakeGroupBinding

class MakeGroupActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMakeGroupBinding
    lateinit var viewPagerAdapter: MainViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMakeGroupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViewPager()
    }

    private fun initViewPager() {
        val list = arrayListOf<Fragment>(
            InitiateGroupFragment.newInstance(),
            JoinGroupFragment.newInstance()
            )

        viewPagerAdapter = MainViewPagerAdapter(this, list)
        binding.mainViewPager.adapter = viewPagerAdapter

        //val draw = Drawable.createFromResourceStream(R.drawable.icon_home,)

        TabLayoutMediator(binding.mainTabLayout, binding.mainViewPager) { tab, position ->
            tab.icon = when (position) {
                0 -> ContextCompat.getDrawable(this, R.drawable.ic_baseline_group_add_24)
                else -> ContextCompat.getDrawable(this, R.drawable.ic_baseline_group_24)
            }

        }.attach()
    }
}